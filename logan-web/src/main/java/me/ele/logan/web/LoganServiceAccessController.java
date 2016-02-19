package me.ele.logan.web;

import java.util.Map;

import me.ele.logan.admin.service.ApiMethodService;
import me.ele.logan.admin.util.KeyUtil;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.AppKeyContext;
import com.rop.security.ServiceAccessController;
import com.rop.session.Session;

public class LoganServiceAccessController implements ServiceAccessController {

	@Autowired
	private ApiMethodService apiMethodService;

	@Override
	public boolean isAppGranted(String appKey, String method, String version, AppKeyContext appKeyContext) {
		if (appKeyContext == null) {
			return false;
		}
		Map<String, String> methodMap = appKeyContext.getMethodMap();
		if (MapUtils.isEmpty(methodMap)) {
			return false;
		}
		String key = KeyUtil.geMethodKey(method, version);
		String status = methodMap.get(key);
		if (StringUtils.isBlank(status) || "0".equals(status)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isUserGranted(Session session, String method, String version) {
		return true;
	}

}
