package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.BizLog;
 /**
 * 业务日志 Service
 * @author qunxi.shao 2015-06-16 13:33:37
 */
public interface BizLogService {

	/**
	 * 插入  业务日志
	 * @param bizLog
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:37
	 */
	Long insert(BizLog bizLog) throws ServiceException;

	
}
