package com.pbs.exceptions;

@SuppressWarnings("serial")
public class AccountIdNotFound extends Exception{
	public AccountIdNotFound(String errorMsg){
		super(errorMsg);
	}

}
