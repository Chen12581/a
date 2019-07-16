package com.wqt.three.qq.login;

/**
 * api业务异常。
 * 
 */
public class ApiException extends RuntimeException {
    
    private static final long serialVersionUID = 1099436364231429639L;
    
    /**
     * 错误代码
     */
    private int code = 0;
    
    /**
     * 错误描述
     */
	private String msg;

	public ApiException() {
		super();
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(String message) {
		super(message);
		this.msg = message;
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(int code, String msg) {
		super(msg);
		this.setCode(code);
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
