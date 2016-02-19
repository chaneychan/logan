
package com.rop.config;

import com.rop.event.RopEventListener;


public class RopEventListenerHodler {

    private RopEventListener ropEventListener;

    public RopEventListenerHodler(RopEventListener ropEventListener) {
        this.ropEventListener = ropEventListener;
    }

    public RopEventListener getRopEventListener() {
        return ropEventListener;
    }
}

