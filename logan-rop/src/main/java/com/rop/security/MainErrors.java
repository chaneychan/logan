
package com.rop.security;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.Assert;

import java.util.Locale;


public class MainErrors {

    protected static Log logger = LogFactory.getLog(MainErrors.class);

    private static final String ERROR_CODE_PREFIX = "ERROR_";
    private static final String ERROR_SOLUTION_SUBFIX = "_SOLUTION";
    // 错误信息的国际化信息
    private static MessageSourceAccessor errorMessageSourceAccessor;

    public static MainError getError(MainErrorType mainErrorType,Locale locale,Object... params) {
        String errorMessage = getErrorMessage(ERROR_CODE_PREFIX + mainErrorType.value(),locale,params);
        String errorSolution = getErrorSolution(ERROR_CODE_PREFIX + mainErrorType.value() + ERROR_SOLUTION_SUBFIX, locale);
        return new SimpleMainError(mainErrorType.value(), errorMessage, errorSolution);
    }

    public static void setErrorMessageSourceAccessor(MessageSourceAccessor errorMessageSourceAccessor) {
        MainErrors.errorMessageSourceAccessor = errorMessageSourceAccessor;
    }

    private static String getErrorMessage(String code, Locale locale,Object... params) {
        try {
            Assert.notNull(errorMessageSourceAccessor, "请先设置错误消息的国际化资源");
            return errorMessageSourceAccessor.getMessage(code, params, locale);
        } catch (NoSuchMessageException e) {
            logger.error("不存在对应的错误键：{}，请检查是否在i18n/rop/error的错误资源", code);
            throw e;
        }
    }

    private static String getErrorSolution(String code, Locale locale) {
        try {
            Assert.notNull(errorMessageSourceAccessor, "请先设置错误解决方案的国际化资源");
            return errorMessageSourceAccessor.getMessage(code, new Object[]{}, locale);
        } catch (NoSuchMessageException e) {
            logger.error("不存在对应的错误键：{}，请检查是否在i18n/rop/error的错误资源", code);
            throw e;
        }
    }


}

