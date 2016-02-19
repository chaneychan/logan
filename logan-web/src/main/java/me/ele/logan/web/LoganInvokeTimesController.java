package me.ele.logan.web;

import javax.annotation.Resource;

import me.ele.ipd.redis.RedisClientProxy;
import me.ele.logan.admin.constant.AdminConstant;
import me.ele.logan.admin.service.AppKeyService;
import me.ele.logan.admin.util.KeyUtil;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.AppKeyContext;
import com.rop.security.InvokeTimesController;
import com.rop.session.Session;

public class LoganInvokeTimesController implements InvokeTimesController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Resource(name = "redis_data_pool")
	private RedisClientProxy redisClientProxy;
	@Autowired
	private AppKeyService appKeyService;

	public void caculateInvokeTimes(String appKey, Session session) {
		String rateKey = KeyUtil.getAppKeyRateKey(appKey);
		redisClientProxy.incr(rateKey, AdminConstant.DEFAULT_EFFECTIVE);
	}

	public boolean isUserInvokeLimitExceed(String appKey, Session session) {
		return false;
	}

	public boolean isSessionInvokeLimitExceed(String appKey, String sessionId) {
		return false; 
	}

	public boolean isAppInvokeLimitExceed(String appKey, AppKeyContext appKeyContext) {
		if(appKeyContext == null){
			return true;
		}
		Long allRate = appKeyContext.getRate();
		// -1 永远不限制访问次数 0不能访问
		if (allRate < 0) {
			return false;
		}
		if (allRate == 0) {
			return true;
		}
		String rateKey =KeyUtil.getAppKeyRateKey(appKey);
		Long rate = null;
		try {
			rate = redisClientProxy.getHasException(rateKey, Long.class);
		} catch (Exception e) {
			logger.error("redis get rate error,will not do business frequency control ,appkey:"+appKey, e);
			return false;
		}
		if (null == rate) {
			return false;
		}
		return allRate <= rate;

	}

	public boolean isAppInvokeFrequencyExceed(String appKey) {
		return false;
	}
}
