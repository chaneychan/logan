package com.rop;

/**
 * <pre>
 * 对请求数据进行解析时发生异常
 * </pre>
 */
public class RopRequestParseException extends RopException {
	private String requestMessage;

	public RopRequestParseException(String requestMessage) {
		this(requestMessage, "");
	}

	public RopRequestParseException(String requestMessage, String message) {
		this(requestMessage, message, null);
	}

	public RopRequestParseException(String requestMessage, Throwable cause) {
		this(requestMessage, null, cause);
	}

	public RopRequestParseException(String requestMessage, String message, Throwable cause) {
		super(message, cause);
		this.requestMessage = requestMessage;
	}
}
