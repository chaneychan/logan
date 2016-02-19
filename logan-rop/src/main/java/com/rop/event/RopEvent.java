package com.rop.event;

import java.util.EventObject;

import com.rop.RopContext;

public abstract class RopEvent extends EventObject {

	private RopContext ropContext;

	public RopEvent(Object source, RopContext ropContext) {
		super(source);
		this.ropContext = ropContext;
	}

	public RopContext getRopContext() {
		return ropContext;
	}
}
