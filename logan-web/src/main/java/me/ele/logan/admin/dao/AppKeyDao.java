package me.ele.logan.admin.dao;

import me.ele.logan.admin.base.BaseDao;
import me.ele.logan.admin.model.AppKey;

public interface AppKeyDao extends BaseDao<AppKey> {
	/**
	 * 动态查询AppKey
	 * @param map: 
	 * @param version
	 * @return
	 */
	AppKey selectDynamic(AppKey appkey);

	AppKey selectByAppKey(String appKey);
		
}
