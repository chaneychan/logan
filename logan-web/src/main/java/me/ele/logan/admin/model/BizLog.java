package me.ele.logan.admin.model;

import java.util.Date;

import me.ele.logan.admin.base.BaseModel;

/**
 * 业务日志
 * 
 * @author qunxi.shao Wed Jun 17 13:35:17 CST 2015
 */

public class BizLog extends BaseModel {

	private static final long serialVersionUID = 787145418669274416L;

	/** 主键 */
	private Long id;

	/** api方法 */
	private String method;

	/** 版本 */
	private String version;

	/** 业务code */
	private String bizCode;

	/** 业务类型 */
	private Integer type;

	/** 请求值 */
	private String requestValue;

	/** 响应值 */
	private String responseValue;

	/** 执行时间 */
	private String time;

	/**  */
	private Long bizId;
	
	private Long moduleId;

	/** 创建时间 */
	private Date createTime;
	
	/** 服务开始时间 */
	private Date startTime;

	/** 服务结束时间 */
	private Date endTime;
	
	/**appkey **/
	private String appKey;
	
	/**客户端ip **/
	private String clientIp;
	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 api方法
	 * 
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 设置 版本
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 设置 业务code
	 * 
	 * @param bizCode
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	/**
	 * 设置 业务类型
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 设置 请求值
	 * 
	 * @param requestValue
	 */
	public void setRequestValue(String requestValue) {
		this.requestValue = requestValue;
	}

	/**
	 * 设置 响应值
	 * 
	 * @param responseValue
	 */
	public void setResponseValue(String responseValue) {
		this.responseValue = responseValue;
	}

	/**
	 * 设置 执行时间
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 设置
	 * 
	 * @param bizId
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	/**
	 * 设置 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 api方法
	 * 
	 * @return method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * 获取 版本
	 * 
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 获取 业务code
	 * 
	 * @return bizCode
	 */
	public String getBizCode() {
		return bizCode;
	}

	/**
	 * 获取 业务类型
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 获取 请求值
	 * 
	 * @return requestValue
	 */
	public String getRequestValue() {
		return requestValue;
	}

	/**
	 * 获取 响应值
	 * 
	 * @return responseValue
	 */
	public String getResponseValue() {
		return responseValue;
	}

	/**
	 * 获取 执行时间
	 * 
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 获取
	 * 
	 * @return bizId
	 */
	public Long getBizId() {
		return bizId;
	}

	/**
	 * 获取 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
}