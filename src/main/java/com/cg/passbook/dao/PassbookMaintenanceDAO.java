package com.cg.passbook.dao;
/******************************************
- File Name      : PassbookMaintenanceDAO.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Interface contains all the queries to be implemented in our module.
 ******************************************/
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.passbook.model.Account;
import com.cg.passbook.model.Transactions;

@Repository 
public interface PassbookMaintenanceDAO extends JpaRepository<Account, String> {
	
	
	@Query("select t from Transactions t where account_Id=?1 and t.transDate>=?2 and t.transDate<=?3")
	List<Transactions> accountSummary(String accountId, Date startDate,Date endDate);
	
	@Query("select u from Account u where account_Id=?1")
	Account get(String accountId);
	
	@Query("select t from Transactions t where account_Id=?1 and t.transDate>(select u.lastUpdated from Account u where account_Id=?1) ")
	List<Transactions> updatePassbook(String accountId);

	@Modifying
	@Query("update Account set lastUpdated=?2 where  account_Id=?1")
	void update(String accountId, Date date);

	Transactions save(Transactions trans);

	
	

	

}