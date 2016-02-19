package me.ele.logan.admin.vo;

import java.util.Date;

import me.ele.logan.admin.base.BaseVo;

/**
 * 参数日志
 * 
 * @author qunxi.shao Wed Jun 17 13:28:49 CST 2015
 */

public class ApiLogVo extends BaseVo {

	private static final long serialVersionUID = 5877993669991890016L;

	/** 主键 */
	private Long id;

	/** appkey */
	private String appKey;

	/** 方法名称 */
	private String methodName;

	/** 版本号 */
	private String version;

	/** 类型 */
	private Integer type;

	/** 调用时间 */
	private Date createTime;

	/** 执行时间 毫秒 */
	private String time;

	/** 调用ip */
	private String clientIp;

	/** 请求参数 */
	private String requestValue;

	/** 响应值 */
	private String responseValue;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 appkey
	 * 
	 * @param appKey
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * 设置 方法名称
	 * 
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 设置 版本号
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * 设置 类型
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 设置 调用时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 设置 执行时间 毫秒
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 设置 调用ip
	 * 
	 * @param clientIp
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	/**
	 * 设置 请求参数
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
	 * 获取 主键
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 获取 appkey
	 * 
	 * @return appKey
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * 获取 方法名称
	 * 
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * 获取 版本号
	 * 
	 * @return version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 获取 类型
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 获取 调用时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 执行时间 毫秒
	 * 
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 获取 调用ip
	 * 
	 * @return clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}

	/**
	 * 获取 请求参数
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

}