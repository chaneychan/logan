
package com.rop.response;

import com.rop.security.MainError;
import com.rop.security.SubError;
import com.rop.security.SubErrorType;
import com.rop.security.SubErrors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Locale;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class TimeoutErrorResponse extends ErrorResponse {

    private static final String ISP = "isp.";

    private static final String SERVICE_TIMEOUT = "-service-timeout";

    public TimeoutErrorResponse() {
    }

    public TimeoutErrorResponse(String method, Locale locale, int timeout) {
        MainError mainError = SubErrors.getMainError(SubErrorType.ISP_SERVICE_TIMEOUT, locale);

        ArrayList<SubError> subErrors = new ArrayList<SubError>();

        String errorCodeKey = ISP + transform(method) + SERVICE_TIMEOUT;
        SubError subError = SubErrors.getSubError(errorCodeKey,
                SubErrorType.ISP_SERVICE_TIMEOUT.value(),
                locale,
                method, timeout);
        subErrors.add(subError);

        setSubErrors(subErrors);
        setMainError(mainError);
    }

}

