package com.rop.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import me.ele.ipd.utils.Coder;

import com.rop.RopException;

/**
 * @author chaney.chan
 * @date 2015年6月17日
 */
public class RopUtils {

	private static final Log logger = LogFactory.getLog(RopUtils.class);

	/**
	 * 使用<code>secret</code>对paramValues按以下算法进行签名： <br/>
	 * uppercase(hex(sha1(secretkey1value1key2value2...secret))
	 *
	 * @param paramValues
	 *            参数列表
	 * @param secret
	 * @return
	 */
	public static String sign(Map<String, String> paramValues, String secret) {
		return sign(paramValues, null, secret);
	}

	/**
	 * 对paramValues进行签名，其中ignoreParamNames这些参数不参与签名
	 * 
	 * @param paramValues
	 * @param ignoreParamNames
	 * @param secret
	 * @return
	 */
	public static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret) {
		try {
			StringBuilder sb = new StringBuilder();
			List<String> paramNames = new ArrayList<String>(paramValues.size());
			paramNames.addAll(paramValues.keySet());
			if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
				for (String ignoreParamName : ignoreParamNames) {
					paramNames.remove(ignoreParamName);
				}
			}
			Collections.sort(paramNames);

			sb.append(secret);
			for (String paramName : paramNames) {
				sb.append(paramName).append(paramValues.get(paramName));
			}
			sb.append(secret);
			byte[] sha1Digest = Coder.getSHA1Digest(sb.toString());
			return Coder.byte2hex(sha1Digest);
		} catch (IOException e) {
			throw new RopException(e);
		}
	}
}
