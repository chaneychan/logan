
package com.rop.security;

import com.rop.AppKeyContext;
import com.rop.session.Session;

/**
 * <pre>
 *    安全控制控制器，决定用户是否有权限访问某个服务（method）。
 * </pre>
 */
public interface ServiceAccessController {

    /**
     * 服务方法是否向ISV开放
     * @param method
     * @param appKeyContext 
     * @param userId
     * @return
     */
    boolean isAppGranted(String appKey, String method, String version, AppKeyContext appKeyContext);

    /**
     *  服务方法是否向当前用户开放
     * @param ropRequestContext
     * @return
     */
    boolean isUserGranted(Session session,String method,String version);
}

