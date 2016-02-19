package me.ele.logan.admin.util;

import me.ele.logan.admin.constant.AdminConstant;

import com.rop.utils.DateUtils;

/**
 * redis key
 * @author shaoqunxi
 *
 */
public class KeyUtil {
	
	/** OPENAPI#### 前缀 **/
	private final static String REDIS_PRE = AdminConstant.SYSTEM + AdminConstant.JOIN_STR;

	/**APPKEY前缀**/
	private final static String  APPKEY_REDIS_PRE=REDIS_PRE+AdminConstant.APPKEY
									+AdminConstant.JOIN_STR;
	
	/**METHOD前缀**/
	private final static String  METHOD_REDIS_PRE= REDIS_PRE+AdminConstant.METHOD
			+AdminConstant.JOIN_STR;
	
	
	/**
	 * 获取appkey 的rediskey
	 * @param appKey
	 * @return
	 */
	public static String getAppKey(String appKey){
		return APPKEY_REDIS_PRE+ appKey;
	}
	
	/**
	 * 获取当前appkey的调用次数
	 * @param appKey
	 * @return
	 */
	public static String getAppKeyRateKey(String appKey)	{
		String date = DateUtils.getCurrDate();
		String rateKey = REDIS_PRE + appKey + AdminConstant.JOIN_STR 
				+ AdminConstant.CURRENTRATE + AdminConstant.JOIN_STR + date;
		return rateKey;
	}
	
	/**
	 *  获取方法的key
	 * @param method
	 * @param version
	 * @return
	 */
	public static String geMethodKey(String method,String version){
		return method+AdminConstant.JOIN_STR+version;
	}

	
	
	public static String getAppKeyMethod(String method,String version){
		String key = METHOD_REDIS_PRE + method
				+ AdminConstant.JOIN_STR+version;
		return  key;
	}
}
