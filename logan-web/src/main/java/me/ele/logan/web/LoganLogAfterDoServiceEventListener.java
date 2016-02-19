package me.ele.logan.web;

import java.util.Date;
import java.util.Map;

import me.ele.logan.admin.model.ApiLog;
import me.ele.logan.admin.model.ApiMethod;
import me.ele.logan.admin.service.ApiLogService;
import me.ele.logan.admin.service.ApiMethodService;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.MessageFormat;
import com.rop.RopRequestContext;
import com.rop.event.AfterDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;

public class LoganLogAfterDoServiceEventListener implements RopEventListener<AfterDoServiceEvent> {

	
	@Autowired
	private ApiMethodService apiMethodService;
	@Autowired
	private ApiLogService apiLogService;
	@Override
	public void onRopEvent(AfterDoServiceEvent ropEvent) {
		 RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
	        if(ropRequestContext != null){
	        	    Map<String,String> allParams = ropRequestContext.getAllParams();
		            String method = ropRequestContext.getMethod();
		            String version = ropRequestContext.getVersion();
		            ApiMethod apiMethod = initMethod(method,version);//
		            
		            if(null != apiMethod ){
		            	
			            String message = allParams.toString();
			            ApiLog log = new ApiLog();
			            log.setAppKey(ropRequestContext.getAppKey());
			            log.setCreator("admin");
			            log.setRequestValue(message); 
			            log.setResponseValue(MessageMarshallerUtils.getMessage(ropRequestContext.getRopResponse(),MessageFormat.json));
			            //log.setBizCode(apiMethod.getBizConf()); //需要定义
			            String clientIp = ropRequestContext.getIp();
			            log.setClientIp(clientIp);
			            log.setCreateTime(new Date());
			            log.setMethodName(method);
			            log.setVersion(version);
			            log.setType(1);
			            log.setBizId(apiMethod.getBizId());
			            log.setModuleId(apiMethod.getModuleId());
			            String time =(ropEvent.getServiceEndTime() -  ropEvent.getServiceBeginTime())+"";
			            log.setTime(time);
			            Date startTime= new Date(ropEvent.getServiceBeginTime());
			            Date endTime= new Date(ropEvent.getServiceEndTime());
			            log.setStartTime(startTime);
			            log.setEndTime(endTime);
			            apiLogService.insert(log);
		            	
		            }    
	        }
	}

	@Override
	public int getOrder() {
		return 0;
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
	

}
