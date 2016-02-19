package me.ele.logan.admin.vo;

import me.ele.logan.admin.base.BaseVo;

public class UserVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 538041164921029237L;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
}
