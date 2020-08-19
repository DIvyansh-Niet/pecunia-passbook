package com.cg.passbook.service;
/******************************************
- File Name      : PassbookMaintenanceService.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Interface is used for abstraction of methpd abstraction and defines all the methods.
 ******************************************/
import java.sql.Date;
import java.util.List;

import com.cg.passbook.model.Account;
import com.cg.passbook.model.Transactions;


public interface PassbookMaintenanceService {

	List<Transactions> accountSummary(String accountId,Date startDate, Date endDate);
	boolean accountValidation(String accountId);
	List<Transactions> updatePassbook(String accountId);
	
	void  updatelastUpdated(String accountId);
	Account saveAccount (Account acc);
	Transactions saveTransactions(Transactions trans);


}
