package com.rop.security;

import com.rop.AppKeyContext;
import com.rop.session.Session;

/**
 * <pre>
 * 默认的实现
 * </pre>
 */
public class DefaultInvokeTimesController implements InvokeTimesController {

	public void caculateInvokeTimes(String appKey, Session session) {
	}

	public boolean isUserInvokeLimitExceed(String appKey, Session session) {
		return false;
	}

	public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
		return false;
	}

	public boolean isAppInvokeFrequencyExceed(String appKey) {
		return false;
	}

	@Override
	public boolean isAppInvokeLimitExceed(String appKey, AppKeyContext appKeyContext) {
		// TODO Auto-generated method stub
		return false;
	}

}
