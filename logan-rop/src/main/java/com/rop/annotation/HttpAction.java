
package com.rop.annotation;

/**
 * <pre>
 *   请求类型的方法
 * </pre>
 */
public enum HttpAction {

    GET, POST;

    public static HttpAction fromValue(String value) {
        if (GET.name().equalsIgnoreCase(value)) {
            return GET;
        } else if (POST.name().equalsIgnoreCase(value)) {
            return POST;
        } else {
            return POST;
        }
    }
}

