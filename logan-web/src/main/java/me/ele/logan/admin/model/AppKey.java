package me.ele.logan.admin.model;

import java.util.Date;

import me.ele.logan.admin.base.BaseModel;

/**
 * appKey
 * 
 * @author qunxi.shao Fri Jun 19 17:20:12 CST 2015
 */

public class AppKey extends BaseModel {

	private static final long serialVersionUID = 2532019546573145611L;

	/** 主键 */
	private Long id;

	/** 用户 */
	private Long userId;

	/** 业务 */
	private Long bizId;

	/** appkey */
	private String appKey;

	/** 密钥 */
	private String appSecret;

	/** 是否启用：1-开启，0-终止，默认开启1 */
	private Integer status;

	/** 总访问数 -1 永远不限制访问次数 0不能访问 */
	private Long rate;

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

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 用户
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 设置 业务
	 * 
	 * @param bizId
	 */
	public void setBizId(Long bizId) {
		this.bizId = bizId;
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
	 * 设置 是否启用：1-开启，0-终止，默认开启1
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设置 总访问数
	 * 
	 * @param rate
	 */
	public void setRate(Long rate) {
		this.rate = rate;
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
	 * 获取 用户
	 * 
	 * @return userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 获取 业务
	 * 
	 * @return bizId
	 */
	public Long getBizId() {
		return bizId;
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
	 * 获取 是否启用：1-开启，0-终止，默认开启1
	 * 
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 获取 总访问数
	 * 
	 * @return rate
	 */
	public Long getRate() {
		return rate;
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

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}