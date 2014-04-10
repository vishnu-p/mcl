package com.mcl.frontend.service.common.exception;

public class MCLServiceException extends RuntimeException {

	private static final long serialVersionUID = -6122971652610530426L;

	private String errorCode;

	private String errorMessage;

	public MCLServiceException() {
		super();
	}

	public MCLServiceException(final Throwable cause, final String errorMessage,
			Exception e) {
		super(errorMessage  + " : " + cause,e);
		this.errorMessage = errorMessage;
	
	}

	public MCLServiceException(final Throwable cause,
			final String errorCode, final String errorMessage) {
		super(errorCode + " : " + errorMessage, cause);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public MCLServiceException(final Throwable cause,
			final String errorMessage) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
	}

	public MCLServiceException(final String errorCode,
			final String errorMessage) {
		super(errorCode + " : " + errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

}