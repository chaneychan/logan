package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.User;
import me.ele.logan.admin.vo.UserVo;
 /**
 * 用户 Service
 * @author qunxi.shao 2015-06-16 13:33:36
 */
public interface UserService {

	/**
	 * 插入  用户
	 * @param userDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(User user) throws ServiceException;

	
	/**
	 * 更新用户
	 * @param user
	 * @return 更新记录数
	 * @throws ServiceException
	 */
	int update(UserVo user) throws ServiceException;
	
	/**
	 * 通过app查询用户信息
	 * @param appKey
	 * @return
	 */
	User selectByAppKey(String appKey);

}
