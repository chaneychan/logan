/**
 
 * 日    期：12-7-27
 */
package me.ele.logan.web;

import com.rop.RopRequest;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;


@ServiceMethodBean(version = "1.0")
public class LogoutService {

    @ServiceMethod(method = "user.logout")
    public Object logout(RopRequest request){
        return null;
    }
}

