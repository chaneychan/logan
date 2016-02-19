package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiMethod;
 /**
 * 方法 Service
 * @author qunxi.shao 2015-06-16 13:33:35
 */
public interface ApiMethodService {

	/**
	 * 插入  方法
	 * @param apiMethodDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:35
	 */
	Long insert(ApiMethod apiMethod) throws ServiceException;

	/**
	 * 动态查询
	 * @param apiMethod
	 * @return
	 * @throws ServiceException
	 */
	ApiMethod  selectDynamic(ApiMethod apiMethod) throws ServiceException;
	
	
	/**
	 * 获取redis 存储的key
	 * key ： methodName +'###' + version
	 * @param key
	 * @return
	 * @throws ServiceException
	 */
	ApiMethod getFromRedis(String methodName,String version) throws ServiceException;

}
