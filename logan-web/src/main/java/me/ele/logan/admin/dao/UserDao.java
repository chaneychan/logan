package me.ele.logan.admin.dao;

import me.ele.logan.admin.base.BaseDao;
import me.ele.logan.admin.model.User;


public interface UserDao extends BaseDao<User> {
	/**
	 * 动态查询User
	 * @param map: 
	 * @param version
	 * @return
	 */
	User selectDynamic(User user);
}
