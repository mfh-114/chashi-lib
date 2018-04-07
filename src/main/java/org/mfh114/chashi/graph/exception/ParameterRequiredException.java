package org.mfh114.chashi.graph.exception;

public class ParameterRequiredException extends ValidatorException {

	private static final long serialVersionUID = -3236627010003657639L;

	public ParameterRequiredException(String message) {
		super(message);
	}

	public ParameterRequiredException(Throwable cause) {
		super(cause);
	}

	public ParameterRequiredException(String message, Throwable cause) {
		super(message, cause);
	}
}
