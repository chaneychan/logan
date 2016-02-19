package me.ele.logan.admin.model;

import me.ele.logan.admin.base.BaseModel;

public class User extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3438695025699617960L;

	/** 主键 */
	private Long id;

	/** appkey */
	private String appKey;

	/** 私钥 */
	private String secretKey;

	/** 用户类型：1-商家，2-开发者，默认1 */
	private Integer type;

	/** 说明 */
	private String description;

	/** 是否启用：1-开启，0-终止，默认开启1 */
	private Integer status;

	/** 名称 */
	private String name;

	/** 邮箱 */
	private String email;

	/** 地址 */
	private String address;

	/** 总访问数 */
	private Integer rate;

	

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
	 * 设置 私钥
	 * 
	 * @param secretKey
	 */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/**
	 * 设置 用户类型：1-商家，2-开发者，默认1
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 设置 说明
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * 设置 名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置 邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 设置 地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 设置 总访问数
	 * 
	 * @param rate
	 */
	public void setRate(Integer rate) {
		this.rate = rate;
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
	 * 获取 私钥
	 * 
	 * @return secretKey
	 */
	public String getSecretKey() {
		return secretKey;
	}

	/**
	 * 获取 用户类型：1-商家，2-开发者，默认1
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 获取 说明
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
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
	 * 获取 名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取 邮箱
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 获取 地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 获取 总访问数
	 * 
	 * @return rate
	 */
	public Integer getRate() {
		return rate;
	}


}
