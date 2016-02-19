
package com.rop.annotation;

/**
 * <pre>
 *    是否需求进行签名校验.{@link #DEFAULT}是系统预留的，请不要在实际中使用
 * </pre>
 */
public enum IgnoreSignType {

    YES, NO, DEFAULT;

    public static boolean isIgnoreSign(IgnoreSignType type) {
        if (NO == type || DEFAULT == type) {
            return false;
        } else {
            return true;
        }
    }
}

