package me.ele.logan.admin.service.impl;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;
import me.ele.logan.admin.constant.AdminConstant;
import me.ele.logan.admin.dao.ApiMethodDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiMethod;
import me.ele.logan.admin.service.ApiMethodService;
import me.ele.logan.admin.util.KeyUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiMethodServiceImpl implements ApiMethodService{

	@Autowired
	private ApiMethodDao apiMethodDao;

	@Resource(name = "redis_data_pool")
    private RedisClientProxy redisClientProxy;
	
	
	@Override
	public Long insert(ApiMethod apiMethod) throws ServiceException {
		return apiMethodDao.insert(apiMethod);
	}

	@Override
	public ApiMethod selectDynamic(ApiMethod apiMethod) throws ServiceException {
		return apiMethodDao.selectDynamic(apiMethod);
	}

	@Override
	public ApiMethod getFromRedis(String methodName, String version)
			throws ServiceException {
		if(StringUtils.isBlank(methodName) || StringUtils.isBlank(version)){
			return null;
		}
		String key = KeyUtil.getAppKeyMethod(methodName.trim(), version.trim());
		try{
			ApiMethod apiMethod = redisClientProxy.get(key,ApiMethod.class);
			if(null == apiMethod){
				apiMethod = new ApiMethod();
				apiMethod.setMethodName(methodName.trim());
				apiMethod.setVersion(version.trim());
				apiMethod = apiMethodDao.selectDynamic(apiMethod);
				redisClientProxy.set(key, apiMethod, AdminConstant.APPKEY_EFFECTIVE);
			}
			return apiMethod;
		}catch(Exception e){
			ApiMethod apiMethod = new ApiMethod();
			apiMethod.setMethodName(methodName.trim());
			apiMethod.setVersion(version.trim());
			apiMethod = apiMethodDao.selectDynamic(apiMethod);
			redisClientProxy.set(key, apiMethod, AdminConstant.APPKEY_EFFECTIVE);
			return apiMethod;
		}
	}
	
	
}
