
package me.ele.logan.web;

import com.rop.RopRequest;
import com.rop.RopRequestContext;
import com.rop.event.AfterDoServiceEvent;
import com.rop.event.RopEventListener;
import com.rop.marshaller.MessageMarshallerUtils;

import java.util.Map;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @deprecated
 * @version 1.0
 */
public class SampleAfterDoServiceEventListener implements RopEventListener<AfterDoServiceEvent> {


    public void onRopEvent(AfterDoServiceEvent ropEvent) {
        RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
        if(ropRequestContext != null){
            Map<String,String> allParams = ropRequestContext.getAllParams();
            String message = MessageMarshallerUtils.asUrlString(allParams);
            System.out.println("message("+ropEvent.getServiceEndTime()+")"+message);
        }
    }


    public int getOrder() {
        return 0;
    }
}

