package me.ele.logan.admin.service.impl;

import me.ele.logan.admin.dao.BizLogDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.BizLog;
import me.ele.logan.admin.service.BizLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bziLogService")
public class BizLogServiceImpl implements BizLogService {

	@Autowired
	private BizLogDao bizLogDao;
	
	@Override
	public Long insert(BizLog bizLog) throws ServiceException {
		return bizLogDao.insert(bizLog);
	}

}
