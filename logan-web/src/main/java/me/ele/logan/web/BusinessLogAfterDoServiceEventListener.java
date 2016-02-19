package me.ele.logan.web;

import java.util.Date;
import java.util.Map;

import me.ele.logan.admin.model.ApiMethod;
import me.ele.logan.admin.model.BizLog;
import me.ele.logan.admin.service.ApiMethodService;
import me.ele.logan.admin.service.BizLogService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.rop.MessageFormat;
import com.rop.RopRequestContext;
import com.rop.event.AfterDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;

public class BusinessLogAfterDoServiceEventListener implements RopEventListener<AfterDoServiceEvent> {
	
	

	@Autowired
	private BizLogService bizLogService;
	
	@Autowired
	private ApiMethodService apiMethodService;
	
	@Override
	public void onRopEvent(AfterDoServiceEvent ropEvent) {
		 //纪录日志
		 RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
	        if(ropRequestContext != null){
	            Map<String,String> allParams = ropRequestContext.getAllParams();
	            String method = ropRequestContext.getMethod();
	            String version = ropRequestContext.getVersion();
	            ApiMethod apiMethod = initMethod(method,version);//
	            if(null != apiMethod 
	            		&&  StringUtils.isNotBlank(apiMethod.getBizConf())){
	            	
	            	String bizConfig = apiMethod.getBizConf();
	            	JSONObject json = new JSONObject();
	            	//BIZ_CONF ,
	            	if(bizConfig.indexOf(",")!=-1){
	            		String [] strs = bizConfig.split(",");
	            		for(String str : strs){
	            			json.put(str, allParams.getOrDefault(str, ""));
	            		}
	            	}else{
	            		json.put(bizConfig, allParams.getOrDefault(bizConfig, ""));
	            	}
	            	
	            	
		            String message = allParams.toString();
		            BizLog bizLog = new BizLog();
		            bizLog.setCreator("admin");
		            bizLog.setRequestValue(message); 
		            bizLog.setResponseValue(MessageMarshallerUtils.getMessage(ropRequestContext.getRopResponse(),MessageFormat.json));
		            bizLog.setBizCode(json.toJSONString()); //需要定义
		            bizLog.setAppKey(ropRequestContext.getAppKey());
		            bizLog.setMethod(method);
		            bizLog.setVersion(version);
		            bizLog.setType(1);
		            bizLog.setBizId(apiMethod.getBizId());
		            bizLog.setModuleId(apiMethod.getModuleId());
		            String time =(ropEvent.getServiceEndTime() -  ropEvent.getServiceBeginTime())+"";
		            bizLog.setTime(time);
		            Date startTime= new Date(ropEvent.getServiceBeginTime());
		            Date endTime= new Date(ropEvent.getServiceEndTime());
		            bizLog.setStartTime(startTime);
		            bizLog.setEndTime(endTime);
		            
		            String clientIp = ropRequestContext.getIp();
		            bizLog.setClientIp(clientIp);
		            
		            bizLogService.insert(bizLog);
	            	
	            }
	        }
	}
	
	/**
	 * 初始化方法
	 * @param methodName
	 * @param version
	 * @return
	 */
	private ApiMethod initMethod(String methodName,String version){
		return apiMethodService.getFromRedis(methodName, version);
	}
	

	@Override
	public int getOrder() {
		return 0;
	}
	
	public static void main(String[] args) {
		JSONObject j = new JSONObject();
		j.put("fdsfdsfsd", "fdsfdscf,fdsf");
		
		System.out.println(j.toJSONString());
		
	}

}
