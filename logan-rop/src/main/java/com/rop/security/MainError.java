
package com.rop.security;

import java.util.List;


public interface MainError {

    String getCode();

    String getMessage();

    String getSolution();

    List<SubError> getSubErrors();

    MainError addSubError(SubError subError);

}

