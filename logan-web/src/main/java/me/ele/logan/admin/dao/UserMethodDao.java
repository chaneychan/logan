package me.ele.logan.admin.dao;

import me.ele.logan.admin.base.BaseDao;
import me.ele.logan.admin.model.UserMethod;


public interface UserMethodDao extends BaseDao<UserMethod> {
	
	/**
	 * 
	 * @param userMethod
	 * @return
	 */
	UserMethod selectDynamic(UserMethod userMethod);

}
