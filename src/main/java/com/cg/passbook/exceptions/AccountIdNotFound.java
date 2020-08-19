package com.cg.passbook.exceptions;
/******************************************
- File Name      : AccountIdNotFound.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Exception class extends the global exception class and carries the error message object.
 ******************************************/

@SuppressWarnings("serial")
public class AccountIdNotFound extends Exception{
	public AccountIdNotFound(String errorMsg){
		super(errorMsg);
	}

}
