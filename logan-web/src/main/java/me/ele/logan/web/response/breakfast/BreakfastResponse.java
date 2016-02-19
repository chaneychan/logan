package me.ele.logan.web.response.breakfast;

public class BreakfastResponse<T> {

	public static final String SUCCESS = "SUCCESS";

	private String status;
	private String message;
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return SUCCESS.equals(status);
	}
}
