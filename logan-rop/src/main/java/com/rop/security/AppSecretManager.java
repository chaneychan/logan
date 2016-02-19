
package com.rop.security;

import com.rop.AppKeyContext;
import com.rop.RopRequestContext;

/**
 * <pre>
 *    应用键管理器,调整：将appKey上下文放入{@link RopRequestContext}
 * </pre>
 */
public interface AppSecretManager {

    /**
     * 是否是合法的appKey
     * @param appKeyContext
     * @return
     */
    boolean isValidAppKey(AppKeyContext appKeyContext);
    
    /**
     * 设置appKey上下文
     * @param appKey
     */
    AppKeyContext getAppKeyContext(String appKey);
    
}

