package org.mfh114.chashi.validator;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.ErrorCode;

public class ValidatorException extends ChashiException {

	private static final long serialVersionUID = 4496308059788806842L;

	public ValidatorException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	public ValidatorException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public ValidatorException(ErrorCode errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

}
