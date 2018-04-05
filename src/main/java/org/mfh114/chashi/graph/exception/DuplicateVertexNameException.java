package org.mfh114.chashi.graph.exception;

public class DuplicateVertexNameException extends ValidatorException {

	private static final long serialVersionUID = 947880790343154662L;

	public DuplicateVertexNameException(String message) {
		super(message);
	}

	public DuplicateVertexNameException(Throwable cause) {
		super(cause);
	}

	public DuplicateVertexNameException(String message, Throwable cause) {
		super(message, cause);
	}
}
