package com.rop.event;

import com.rop.RopContext;

/**
 * <pre>
 * 在Rop框架初始化后产生的事件
 * </pre>
 */
public class AfterStartedRopEvent extends RopEvent {

	public AfterStartedRopEvent(Object source, RopContext ropContext) {
		super(source, ropContext);
	}

}
