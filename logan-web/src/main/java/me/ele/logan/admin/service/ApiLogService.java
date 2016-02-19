package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiLog;
 /**
 * 参数日志 Service
 * @author qunxi.shao 2015-06-16 13:33:36
 */
public interface ApiLogService {

	/**
	 * 插入  参数日志
	 * @param apiLogDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(ApiLog apiLog) throws ServiceException;

	
}
