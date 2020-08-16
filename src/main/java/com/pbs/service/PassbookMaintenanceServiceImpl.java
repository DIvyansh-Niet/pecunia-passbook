package com.pbs.service;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.PassbookMaintenanceDAO;
import com.pbs.model.Account;
import com.pbs.model.Transactions;


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


	
}

	
	
