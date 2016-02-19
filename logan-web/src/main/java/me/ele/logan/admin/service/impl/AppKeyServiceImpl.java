package me.ele.logan.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;
import me.ele.logan.admin.constant.AdminConstant;
import me.ele.logan.admin.dao.ApiMethodDao;
import me.ele.logan.admin.dao.AppKeyDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiMethod;
import me.ele.logan.admin.model.AppKey;
import me.ele.logan.admin.service.AppKeyService;
import me.ele.logan.admin.util.KeyUtil;
import me.ele.logan.admin.vo.ApiMethodVo;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rop.AppKeyContext;

@Service
public class AppKeyServiceImpl implements AppKeyService {

	@Autowired
	private AppKeyDao appKeyDao;
	
	@Autowired
	private ApiMethodDao apiMethodDao;
	
	@Resource(name = "redis_data_pool")
    private RedisClientProxy redisClientProxy;
	
	
	@Override
	public Long insert(AppKey appKey) throws ServiceException {
		return appKeyDao.insert(appKey);
	}
	
	@Override
	public AppKeyContext selectByAppKey(String appkey) throws ServiceException {
		if(StringUtils.isBlank(appkey)){
			return null;
		}
		appkey = appkey.trim();
		String key =KeyUtil.getAppKey(appkey);
		try{
			AppKeyContext context = redisClientProxy.get(key, AppKeyContext.class);
			if(null == context){
				context = initAppKey(appkey);
				redisClientProxy.set(key, context,AdminConstant.APPKEY_EFFECTIVE);
				return context;
			}
			return context;
		}catch(Exception e){
			AppKeyContext context = initAppKey(appkey);
			redisClientProxy.set(key, context, AdminConstant.APPKEY_EFFECTIVE);
			return context;
		}
	}
	
	/**
	 * 初始化appKeyContext
	 * @param appKey
	 * @return
	 */
	private  AppKeyContext initAppKey(String appKey){
		AppKey app = appKeyDao.selectByAppKey(appKey);
		if(null != app){
			AppKeyContext context = new AppKeyContext();
			context.setAppKey(app.getAppKey());
			context.setAppSecret(app.getAppSecret());
			context.setRate(app.getRate());
			context.setStatus(app.getStatus());
			Long bizId = null;
			
			ApiMethodVo apiMethodVo = new ApiMethodVo();
			apiMethodVo.setBizId(bizId);
			List<ApiMethod> methodList = apiMethodDao.selectByBizId(apiMethodVo);
			if(!CollectionUtils.isEmpty(methodList)){
				Map<String,String> methodMap = new HashMap<String,String>();
				for(ApiMethod method : methodList){
					String key = method.getMethodName() +AdminConstant.JOIN_STR +method.getVersion();
					methodMap.put(key, method.getStatus().toString());
				}
				context.setMethodMap(methodMap);
			}
			return context;
		}
		return null;
	}

	@Override
	public void deleteRedisAppKey(String appkey) throws ServiceException {
		if(StringUtils.isNotBlank(appkey)){
			appkey = appkey.trim();
			String key =KeyUtil.getAppKey(appkey);
			redisClientProxy.delete(key);
		}
	}


}
