package org.mfh114.chashi;

/**
 * <p>
 * This class represents Chashi library's base runtime exception class.
 * </p>
 * <p>
 * Chashi lib does not throw any checked exception because user cannot recover
 * from the exception, if exception occurred.
 * </p>
 * <p>
 * Anyhow, I am not going to debate about checked or unchecked exception here.
 * If you want debate please go to the Oracle to debate about it. Ref: <a href=
 * "https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html">
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html</a>
 * </p>
 */
public class ChashiException extends RuntimeException {

	private static final long serialVersionUID = -3593120604518035473L;
	private ErrorCode errorCode;

	public ChashiException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ChashiException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public ChashiException(ErrorCode errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
