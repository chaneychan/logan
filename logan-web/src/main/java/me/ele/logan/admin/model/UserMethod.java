package me.ele.logan.admin.model;

import java.util.Date;

import me.ele.logan.admin.base.BaseModel;

/**
 * 流量控制
 * 
 * @author qunxi.shao Wed Jun 17 14:11:48 CST 2015
 */

public class UserMethod extends BaseModel {

	private static final long serialVersionUID = -1212395112732138250L;

	/** 主键 */
	private Long id;

	/**  */
	private Long userId;

	/**  */
	private Long methodId;

	/** 每分多少次调用 */
	private Integer rate;

	/** 状态：0-作废，1启用 */
	private Integer status;

	/** 创建时间 */
	private Date createTime;

	/** 创建人 */
	private String creator;

	/** 修改时间 */
	private Date lastModified;

	/** 修改人 */
	private String modifiedBy;

	/** 创建人id */
	private Long creatorId;
	
	/** 方法名称**/
	private String methodName;
	
	/** appkey **/
	private String appKey;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置
	 * 
	 * @param methodId
	 */
	public void setMethodId(Long methodId) {
		this.methodId = methodId;
	}

	/**
	 * 设置 每分多少次调用
	 * 
	 * @param rate
	 */
	public void setRate(Integer rate) {
		this.rate = rate;
	}

	/**
	 * 设置 状态：0-作废，1启用
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
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
	 * 设置 创建人
	 * 
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 设置 修改时间
	 * 
	 * @param lastModified
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * 设置 修改人
	 * 
	 * @param modifiedBy
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * 设置 创建人id
	 * 
	 * @param creatorId
	 */
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
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
	 * 获取
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取
	 * 
	 * @return methodId
	 */
	public Long getMethodId() {
		return methodId;
	}

	/**
	 * 获取 每分多少次调用
	 * 
	 * @return rate
	 */
	public Integer getRate() {
		return rate;
	}

	/**
	 * 获取 状态：0-作废，1启用
	 * 
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 获取 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 获取 创建人
	 * 
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 获取 修改时间
	 * 
	 * @return lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * 获取 修改人
	 * 
	 * @return modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * 获取 创建人id
	 * 
	 * @return creatorId
	 */
	public Long getCreatorId() {
		return creatorId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

}