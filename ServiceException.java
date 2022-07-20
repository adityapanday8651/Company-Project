package com.kisanlink.exception;

/**
 * @author Silxo
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	protected int code;
	protected String error;

	public ServiceException(String error) {
		super(error);
	}

	public ServiceException(int code, String error) {
		super(error);
		this.code = code;
		this.error = error;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String error, Throwable cause) {
		super(error, cause);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int errCode) {
		this.code = errCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}