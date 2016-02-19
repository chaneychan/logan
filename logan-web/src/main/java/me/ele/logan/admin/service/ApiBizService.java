package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiBiz;
 /**
 * 业务 Service
 * @author qunxi.shao 2015-06-16 13:33:36
 */
public interface ApiBizService {

	/**
	 * 插入  流量控制
	 * @param apiRateDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(ApiBiz apiBiz) throws ServiceException;

	
}
