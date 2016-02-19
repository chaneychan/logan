package me.ele.logan.admin.exception;

import java.util.List;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8013200853461709878L;
	private String errCode;

	private String[] params;

	private String message;


	public BusinessException() {

	}

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

	public BusinessException(String errCode) {
		this.errCode = errCode;
		if (message == null) {
			this.message = errCode;
		}
	}

	public BusinessException(String errCode, List<String> params) {
		this.errCode = errCode;
		this.params = (String[]) params.toArray();
		if (message == null) {
			this.message = errCode;
		}
	}

	public BusinessException(String errCode, String... params) {
		this.errCode = errCode;
		this.params = params;
		if (message == null) {
			this.message = errCode;
		}
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
		if (message == null) {
			this.message = errCode;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}