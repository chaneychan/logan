package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.UserMethod;
 /**
 * 流量控制 Service
 * @author qunxi.shao 2015-06-16 13:33:36
 */
public interface UserMethodService {

	/**
	 * 插入  流量控制
	 * @param userMethod
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(UserMethod userMethod) throws ServiceException;
	
	/**
	 * 动态查询流控
	 * @param userMethod
	 * @return
	 * @throws ServiceException
	 */
	UserMethod selectDynamic(UserMethod userMethod) throws ServiceException;
	
	
	
	

	
}
