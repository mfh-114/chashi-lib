package org.mfh114.chashi.validator.exception;

import org.mfh114.chashi.graph.exception.ChashiException;

public class ValidatorException extends ChashiException {

	private static final long serialVersionUID = 4496308059788806842L;

	public ValidatorException(String message) {
		super(message);
	}

	public ValidatorException(Throwable cause) {
		super(cause);
	}

	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

}
