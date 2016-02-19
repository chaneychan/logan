
package com.rop.request;

import org.springframework.core.convert.converter.Converter;


public interface RopConverter<S, T> extends Converter<S, T> {

    /**
     * 从T转换成S
     * @param target
     * @return
     */
    S unconvert(T target);

    /**
     * 获取源类型
     * @return
     */
    Class<S> getSourceClass();

    /**
     * 获取目标类型
     * @return
     */
    Class<T> getTargetClass();
}

