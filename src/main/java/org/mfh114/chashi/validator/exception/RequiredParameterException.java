package org.mfh114.chashi.validator.exception;

public class RequiredParameterException extends ValidatorException {

	private static final long serialVersionUID = -3236627010003657639L;

	public RequiredParameterException(String message) {
		super(message);
	}

	public RequiredParameterException(Throwable cause) {
		super(cause);
	}

	public RequiredParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
