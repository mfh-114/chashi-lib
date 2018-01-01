package org.mfh114.chashi.graph;

import org.mfh114.chashi.ChashiException;
import org.mfh114.chashi.ErrorCode;

public class InvalidVertexNameException extends ChashiException {

	private static final long serialVersionUID = -1463587738302090547L;

	public InvalidVertexNameException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	public InvalidVertexNameException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public InvalidVertexNameException(ErrorCode errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}
}
