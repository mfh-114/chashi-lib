package org.mfh114.chashi.graph.exception;

public class GraphInLoopException extends ChashiException {

	private static final long serialVersionUID = 743655205308596855L;

	public GraphInLoopException(String message) {
		super(message);
	}

	public GraphInLoopException(Throwable cause) {
		super(cause);
	}

	public GraphInLoopException(String message, Throwable cause) {
		super(message, cause);
	}
}
