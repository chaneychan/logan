package me.ele.logan.admin.service.impl;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;
import me.ele.logan.admin.constant.AdminConstant;
import me.ele.logan.admin.dao.UserDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.User;
import me.ele.logan.admin.service.UserService;
import me.ele.logan.admin.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Resource(name = "redis_data_pool")
    private RedisClientProxy redisClientProxy;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public Long insert(User user) throws ServiceException {
		if(user == null ){
			throw new ServiceException("用户不能为空");
		}
		return userDao.insert(user);
	}

	@Override
	public User selectByAppKey(String appKey) {
		String key = AdminConstant.SYSTEM+AdminConstant.JOIN_STR+AdminConstant.APPKEY;
		try{
			User user = redisClientProxy.get(key, User.class);
			if(null == user){
				user = new 	User();
				user.setAppKey(appKey);
				user = userDao.selectDynamic(user);
				if(null == user){
					return null;
				}
				redisClientProxy.set(key, user, AdminConstant.DEFAULT_EFFECTIVE);
			}
			return user;
		}catch(Exception e){
			User user = new 	User();
			user.setAppKey(appKey);
			user = userDao.selectDynamic(user);
			return user;
		}
	}

	@Override
	public int update(UserVo user) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
