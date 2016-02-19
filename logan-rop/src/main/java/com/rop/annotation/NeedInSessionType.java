
package com.rop.annotation;

/**
 * <pre>
 * 功能说明：是否需求会话检查
 * </pre>
 */
public enum NeedInSessionType {
    YES, NO, DEFAULT;

    public static boolean isNeedInSession(NeedInSessionType type) {
        if (YES == type || DEFAULT == type) {
            return true;
        } else {
            return false;
        }
    }
}

