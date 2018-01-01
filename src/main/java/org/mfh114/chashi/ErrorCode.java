package org.mfh114.chashi;

/****
 * 
 * This class represents finite set of exception's error code and corresponding
 * default message.
 *
 */
public enum ErrorCode {

	/** All 400 category error are caused because of invalid user input */
	REQUIRED_PARAM("ERR400", "Parameter required."), 
	DUP_VERTEX_NAME("ERR401", "Duplicate vertex name."),
	INVALID_VERTEX_NAME("ERR402", "Invalid vertex name."),

	/** All 500 category error are caused by programming error */
	INTERNAL_ERROR("ERR500", "Internal error.");

	private String errorCode;
	private String errMsg;

	private ErrorCode(String errorCode, String errMsg) {
		this.errorCode = errorCode;
		this.errMsg = errMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errMsg;
	}
}
