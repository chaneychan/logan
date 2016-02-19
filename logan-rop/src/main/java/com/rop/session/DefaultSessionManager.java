package com.rop.session;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author libinsong@gmail.com
 itstamen@qq.com
 */
public final class DefaultSessionManager implements SessionManager {

    protected final Log logger = LogFactory.getLog(getClass());

    private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);


    public void addSession(String sessionId, Session session) {
        sessionCache.put(sessionId, session);
    }


    public Session getSession(String sessionId) {
        return sessionCache.get(sessionId);
    }


    public void removeSession(String sessionId) {
        sessionCache.remove(sessionId);
    }

}