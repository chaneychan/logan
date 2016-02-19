package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.AppKey;

import com.rop.AppKeyContext;

public interface AppKeyService {
	/**
	 * 插入  appkey
	 * @param userDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(AppKey appKey) throws ServiceException;
	
	
	/**
	 * 通过appkey查询appkey的上下文
	 * @param appkey
	 * @return
	 * @throws ServiceException
	 */
	AppKeyContext selectByAppKey(String appkey) throws ServiceException;
	
	/**
	 * 删除redis里面到appkey
	 * @param appkey
	 * @throws ServiceException
	 */
	void deleteRedisAppKey(String appkey) throws ServiceException;
}
