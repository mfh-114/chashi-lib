package org.mfh114.chashi.graph.exception;

public class InvalidVertexNameException extends ChashiException {

	private static final long serialVersionUID = 7108047360400702107L;

	public InvalidVertexNameException(String message) {
		super(message);
	}

	public InvalidVertexNameException(Throwable cause) {
		super(cause);
	}

	public InvalidVertexNameException(String message, Throwable cause) {
		super(message, cause);
	}
}
