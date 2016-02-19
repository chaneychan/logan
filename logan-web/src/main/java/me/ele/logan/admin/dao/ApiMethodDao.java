package me.ele.logan.admin.dao;

import java.util.List;

import me.ele.logan.admin.base.BaseDao;
import me.ele.logan.admin.model.ApiMethod;
import me.ele.logan.admin.vo.ApiMethodVo;


public interface ApiMethodDao extends BaseDao<ApiMethod> {
	/**
	 * 
	 * @param map: 
	 * @param version
	 * @return
	 */
	ApiMethod selectDynamic(ApiMethod apiMethod);
	
	List<ApiMethod> selectByBizId(ApiMethodVo apiMethodVo);
	
}
