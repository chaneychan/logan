package me.ele.logan.admin.service.impl;

import me.ele.logan.admin.dao.ApiLogDao;
import me.ele.logan.admin.exception.ServiceException;
import me.ele.logan.admin.model.ApiLog;
import me.ele.logan.admin.service.ApiLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "apiLogService")
public class ApiLogServiceImpl implements ApiLogService {

	@Autowired
	private ApiLogDao apiLogDao;
	
	@Override
	public Long insert(ApiLog apiLog) throws ServiceException {
		return apiLogDao.insert(apiLog);
	}

}
