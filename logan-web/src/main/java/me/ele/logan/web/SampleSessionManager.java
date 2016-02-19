/**
 
 * 日    期：12-7-17
 */
package me.ele.logan.web;

import com.rop.session.Session;
import com.rop.session.SessionManager;
import me.ele.elog.Log;
import me.ele.elog.LogFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SampleSessionManager implements SessionManager{
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

