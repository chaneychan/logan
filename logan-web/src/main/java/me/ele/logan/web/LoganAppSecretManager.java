package me.ele.logan.web;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import me.ele.ipd.utils.AESCoder;
import me.ele.ipd.utils.Coder;
import me.ele.logan.admin.service.AppKeyService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.AppKeyContext;
import com.rop.security.AppSecretManager;

public class LoganAppSecretManager implements AppSecretManager {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private AppKeyService appKeyService;

	@Override
	public boolean isValidAppKey(AppKeyContext appKeyContext) {
		if (appKeyContext == null || StringUtils.isBlank(appKeyContext.getAppKey()) || appKeyContext.getStatus() == null
				|| 0 == appKeyContext.getStatus()) {
			return false;
		}

		String appKey = appKeyContext.getAppKey();
		try {
			String s = appKey.substring(0, 9);
			String sEnd = appKey.substring(9);
			String encode = Coder.hexEncode(AESCoder.encrypt(s));
			String encodeEnd = encode.substring(encode.length() - 8, encode.length() - 7);
			return sEnd.equals(encodeEnd);
		} catch (Exception e) {
			logger.error("isValidAppKey error", e);
		}
		return false;
	}

	@Override
	public AppKeyContext getAppKeyContext(String appKey) {
		AppKeyContext context = appKeyService.selectByAppKey(appKey);
		return context;
	}

}
