package org.mfh114.chashi.fsm;

import org.mfh114.chashi.ErrorCode;

public class Error {

	private ErrorCode errorCode;
	private String message;

	public Error(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public Error(ErrorCode errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
}
