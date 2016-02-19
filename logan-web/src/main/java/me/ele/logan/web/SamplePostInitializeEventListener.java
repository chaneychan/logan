
package me.ele.logan.web;

import com.rop.event.AfterStartedRopEvent;
import com.rop.event.RopEventListener;


public class SamplePostInitializeEventListener implements RopEventListener<AfterStartedRopEvent> {


    public void onRopEvent(AfterStartedRopEvent ropRopEvent) {
        System.out.println("execute SamplePostInitializeEventListener!");
    }


    public int getOrder() {
        return 0;
    }
}

