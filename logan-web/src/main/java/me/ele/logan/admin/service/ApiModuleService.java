package me.ele.logan.admin.service;

import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiModule;
 /**
 * 子业务模块 Service
 * @author qunxi.shao 2015-06-16 13:33:36
 */
public interface ApiModuleService {

	/**
	 * 插入  子业务模块
	 * @param apiModuleDO
	 * @return 主键
	 * @throws ServiceException
	 * @author qunxi.shao 2015-06-16 13:33:36
	 */
	Long insert(ApiModule apiModule) throws ServiceException;

	
}
