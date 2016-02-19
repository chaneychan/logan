package com.rop;

import java.io.Serializable;
import java.util.Map;

/**
 * appkey 上下文
 * @author shaoqunxi
 *
 */
public class AppKeyContext  implements Serializable{
	
	private static final long serialVersionUID = -4021564162769557879L;

	/** appkey */
	private String appKey;
	
	/** 密钥 */
	private String appSecret;
	
	/** 总访问数 -1 永远不限制访问次数 0不能访问 */
	private Long rate;
	
	/** 是否启用：1-开启，0-终止，默认开启1 */
	private Integer status;
	
	/** appKey 对应的方法 **/
	private Map<String,String> methodMap;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Map<String, String> getMethodMap() {
		return methodMap;
	}

	public void setMethodMap(Map<String, String> methodMap) {
		this.methodMap = methodMap;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
}
