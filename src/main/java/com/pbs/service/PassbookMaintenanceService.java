package com.pbs.service;
import java.sql.Date;
import java.util.List;

import com.pbs.model.Transactions;

public interface PassbookMaintenanceService {

	List<Transactions> accountSummary(String accountId,Date startDate, Date endDate);
	boolean accountValidation(String accountId);
	List<Transactions> updatePassbook(String accountId);
	
	void  updatelastUpdated(String accountId);


}
