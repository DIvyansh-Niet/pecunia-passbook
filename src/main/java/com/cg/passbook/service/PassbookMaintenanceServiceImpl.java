package com.cg.passbook.service;
/******************************************
- File Name      : PassbookMaintenanceServiceImpl.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Service class implements all the methods defined in the interface.
 ******************************************/
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.passbook.dao.PassbookMaintenanceDAO;
import com.cg.passbook.model.Account;
import com.cg.passbook.model.Transactions;


@Service
public class PassbookMaintenanceServiceImpl implements PassbookMaintenanceService {

	@Autowired
	private PassbookMaintenanceDAO dao;
	Account account=new Account();
	long millis=System.currentTimeMillis();  
	Date date=new Date(millis); 

	@Override
	public List<Transactions> accountSummary(String accountId, Date startDate, Date endDate) {
		return dao.accountSummary(accountId, startDate, endDate);
	}
	//Implementation of Account validation method. 
	@Override
	public boolean accountValidation(String accountId) {
		 account=dao.get(accountId);
		if(account==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	public List<Transactions> updatePassbook(String accountId){
		List<Transactions> result=dao.updatePassbook(accountId);
		updatelastUpdated(accountId);
		return result;	
		
	}

	@Override
	public void updatelastUpdated(String accountId) {
		 dao.update(accountId,date);
	}
	 @Override
	 public Account saveAccount(Account acc) {
		 return dao.save(acc);
	 }
	 @Override
	 public Transactions saveTransactions(Transactions trans) {
		 return dao.save(trans);
	 }

	
}

	
	
