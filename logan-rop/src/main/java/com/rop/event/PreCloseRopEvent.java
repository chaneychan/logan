
package com.rop.event;

import com.rop.RopContext;


public class PreCloseRopEvent extends RopEvent {
    public PreCloseRopEvent(Object source, RopContext ropContext) {
        super(source, ropContext);
    }
}

