/**
 
 * 日    期：12-7-17
 */
package me.ele.logan.web;

import java.util.Map;

import com.rop.RopRequestContext;
import com.rop.event.PreDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;


public class SamplePreDoServiceEventListener implements RopEventListener<PreDoServiceEvent> {


    public void onRopEvent(PreDoServiceEvent ropEvent) {
        RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
        if(ropRequestContext != null){
            Map<String,String> allParams = ropRequestContext.getAllParams();
            String message = MessageMarshallerUtils.asUrlString(allParams);
            System.out.println("message("+ropEvent.getServiceBeginTime()+")"+message);
        }
    }


    public int getOrder() {
        return 1;
    }
}

