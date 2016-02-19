package me.ele.logan.admin.constant;
/**
 * 
 * @author shaoqunxi
 *
 */
public class AdminConstant {
	public final static String JOIN_STR = "####";
	
	/**redis 前缀**/
	public final static String SYSTEM="OPENAPI";
	public final static String APPKEY = "APPKEY"; 
	public final static String METHOD="METHOD";
	
	/** 流控**/
	public final static String ALLRATE = "ALLRATE";
	public final static String CURRENTRATE="RATE";
	
	/** 默认一天 **/
	public final static Integer DEFAULT_EFFECTIVE = 60*24;
	

	/** appkey 默认失效时间 **/
	public final static Integer APPKEY_EFFECTIVE = 60*24*30;
}
