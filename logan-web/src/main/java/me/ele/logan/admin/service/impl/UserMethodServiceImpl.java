package me.ele.logan.admin.service.impl;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;
import me.ele.logan.admin.constant.AdminConstant;
import me.ele.logan.admin.dao.UserMethodDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.UserMethod;
import me.ele.logan.admin.service.UserMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMethodServiceImpl implements UserMethodService {

	
	@Resource(name = "redis_data_pool")
    private RedisClientProxy redisClientProxy;
	
	@Autowired
	private UserMethodDao userMethodDao;
	
	/**Redis 前缀**/
	private final static String REDIS_PRE = AdminConstant.SYSTEM+AdminConstant.JOIN_STR
			+AdminConstant.APPKEY+AdminConstant.JOIN_STR
			+AdminConstant.METHOD+AdminConstant.JOIN_STR;
	
	@Override
	public Long insert(UserMethod userMethod) throws ServiceException {
		return userMethodDao.insert(userMethod);
	}

	@Override
	public UserMethod selectDynamic(UserMethod userMethod) throws ServiceException {
		String key =REDIS_PRE+userMethod.getMethodName();
		try{
			UserMethod uMethod = redisClientProxy.get(key, UserMethod.class);
			if(null == uMethod){
				uMethod = new 	UserMethod();
				uMethod.setMethodName(uMethod.getMethodName());
				uMethod.setAppKey(uMethod.getAppKey());
				uMethod = userMethodDao.selectDynamic(uMethod);
				if(null == uMethod){
					return null;
				}
				redisClientProxy.set(key, uMethod, AdminConstant.DEFAULT_EFFECTIVE);
			}
			return uMethod;
		}catch(Exception e){
			UserMethod uMethod = new UserMethod();
			uMethod.setMethodName(userMethod.getMethodName());
			uMethod.setAppKey(userMethod.getAppKey());
			userMethodDao.selectDynamic(uMethod);
			redisClientProxy.set(key, uMethod, AdminConstant.DEFAULT_EFFECTIVE);
			return uMethod;
		}
	}

}
