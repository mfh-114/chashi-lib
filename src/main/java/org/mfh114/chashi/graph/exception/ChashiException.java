package org.mfh114.chashi.graph.exception;

/**
 * <p>
 * This class represents Chashi library's base checked Exception class.
 * </p>
 */
public class ChashiException extends Exception {

	private static final long serialVersionUID = 5119288019050205985L;

	public ChashiException(String message) {
		super(message);
	}

	public ChashiException(Throwable cause) {
		super(cause);
	}

	public ChashiException(String message, Throwable cause) {
		super(message, cause);
	}
}
