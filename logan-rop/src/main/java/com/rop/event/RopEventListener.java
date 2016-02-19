
package com.rop.event;

import java.util.EventListener;

/**
 * <pre>
 *    监听所有Rop框架的事件
 * </pre>
 */
public interface RopEventListener<E extends RopEvent> extends EventListener {

    /**
     * 响应事件
     *
     * @param ropEvent
     */
    void onRopEvent(E ropEvent);

    /**
     * 执行的顺序号
     *
     * @return
     */
    int getOrder();
}
