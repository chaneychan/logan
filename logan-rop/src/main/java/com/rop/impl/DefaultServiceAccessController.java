package com.rop.impl;

import com.rop.AppKeyContext;
import com.rop.security.ServiceAccessController;
import com.rop.session.Session;

/**
 * <pre>
 * 功能说明：对调用的方法进行安全性检查
 * </pre>
 */
public class DefaultServiceAccessController implements ServiceAccessController {

	public boolean isUserGranted(Session session, String method, String version) {
		return true;
	}

	@Override
	public boolean isAppGranted(String appKey, String method, String version, AppKeyContext appKeyContext) {
		// TODO Auto-generated method stub
		return false;
	}
}
