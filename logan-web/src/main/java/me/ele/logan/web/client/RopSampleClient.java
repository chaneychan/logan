/**
 
 * 日    期：12-8-4
 */
package me.ele.logan.web.client;

import me.ele.logan.web.converter.TelephoneConverter;
import me.ele.logan.web.request.LogonRequest;
import me.ele.logan.web.response.LogonResponse;

import com.rop.client.ClientRequest;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;


public class RopSampleClient {

    public static final String SERVER_URL = "http://localhost:8088/router";

    private DefaultRopClient ropClient ;

    /**
     * 创建客户端对象
     * @param appKey
     * @param secret
     */
    public RopSampleClient(String appKey,String secret) {
        ropClient = new DefaultRopClient(SERVER_URL, appKey, secret);
        ropClient.setFormatParamName("messageFormat");
        ropClient.addRopConvertor(new TelephoneConverter());
    }

    /**
     * 登录系统
     *
     * @return
     */
    public String logon(String userName, String password) {
        LogonRequest ropRequest = new LogonRequest();
        ropRequest.setUserName("tomson");
        ropRequest.setPassword("123456");
        CompositeResponse response = ropClient.buildClientRequest().get(ropRequest, LogonResponse.class, "user.logon", "1.0");
        String sessionId = ((LogonResponse) response.getSuccessResponse()).getSessionId();
        ropClient.setSessionId(sessionId);
        return sessionId;
    }

    public void logout() {
        ropClient.buildClientRequest().get(LogonResponse.class, "user.logout", "1.0");
    }

    public ClientRequest buildClientRequest(){
        return ropClient.buildClientRequest();
    }
}

