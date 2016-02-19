package me.ele.logan.admin.vo;

import java.util.Date;

import me.ele.logan.admin.base.BaseVo;

/**
 * 子业务模块
 * 
 * @author qunxi.shao Wed Jun 17 14:11:47 CST 2015
 */

public class ApiModuleVo extends BaseVo {

	private static final long serialVersionUID = 8670610233200546243L;

	/** 主键 */
	private Long id;

	/**  */
	private Integer bizId;

	/** 子业务模块 */
	private String name;

	/** 描述 */
	private String desc;

	/** 1-启用，0-禁用 */
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
	 * @param bizId
	 */
	public void setBizId(Integer bizId) {
		this.bizId = bizId;
	}

	/**
	 * 设置 子业务模块
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 描述
	 * 
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 设置 1-启用，0-禁用
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
	 * @return bizId
	 */
	public Integer getBizId() {
		return bizId;
	}

	/**
	 * 获取 子业务模块
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 描述
	 * 
	 * @return desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 获取 1-启用，0-禁用
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

}