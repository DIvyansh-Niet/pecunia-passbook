package com.cg.passbook.exceptions;/******************************************
- File Name      : RecordErrorResponse.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Exception class act as a pojo class for error messages.
 ******************************************/


@SuppressWarnings("serial")
public class RecordErrorResponse extends Exception {
	private final int errorCode;
    private final String errorMessage;
   
    

	public int getErrorCode() {
		return errorCode;
	}



	public String getErrorMessage() {
		return errorMessage;
	}



	public RecordErrorResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
	
