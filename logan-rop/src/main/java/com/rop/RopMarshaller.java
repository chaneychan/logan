
package com.rop;

import java.io.OutputStream;

/**
 * <pre>
 *   负责将请求方法返回的响应对应流化为相应格式的内容。
 * </pre>
 */
public interface RopMarshaller {
    void marshaller(Object object, OutputStream outputStream);
}

