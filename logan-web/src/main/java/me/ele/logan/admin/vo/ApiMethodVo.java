package me.ele.logan.admin.vo;

import java.util.Date;

import me.ele.logan.admin.base.BaseVo;

/**
 * 方法
 * 
 * @author qunxi.shao Wed Jun 17 14:11:47 CST 2015
 */

public class ApiMethodVo extends BaseVo {

	private static final long serialVersionUID = 7830205028199183541L;

	/** 主键 */
	private Long id;

	/** 模块表 */
	private Long moduleId;

	/**  */
	private String methodName;

	/** 饿了么内部服务名称 */
	private String bizMethodName;

	/** 版本号 */
	private String version;

	/** 状态：1－启用，0-禁用 */
	private Integer status;

	/** 配置业务唯一性纪录 */
	private String bizConf;

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
	
	/** 业务表 */
	private Long bizId;

	/**
	 * 设置 主键
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 设置 模块表
	 * 
	 * @param moduleId
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * 设置
	 * 
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * 设置 饿了么内部服务名称
	 * 
	 * @param bizMethodName
	 */
	public void setBizMethodName(String bizMethodName) {
		this.bizMethodName = bizMethodName;
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
	 * 设置 状态：1－启用，0-禁用
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 设置 配置业务唯一性纪录
	 * 
	 * @param bizConf
	 */
	public void setBizConf(String bizConf) {
		this.bizConf = bizConf;
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
	 * 获取 模块表
	 * 
	 * @return moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * 获取
	 * 
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * 获取 饿了么内部服务名称
	 * 
	 * @return bizMethodName
	 */
	public String getBizMethodName() {
		return bizMethodName;
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
	 * 获取 状态：1－启用，0-禁用
	 * 
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 获取 配置业务唯一性纪录
	 * 
	 * @return bizConf
	 */
	public String getBizConf() {
		return bizConf;
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

	public Long getBizId() {
		return bizId;
	}

	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	
	

}