package com.cg.passbook.controller;
/******************************************
- File Name      : PassbookController.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Controller class act as an end point to manage the entire PassbookMaintenanceService.
 ******************************************/
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.passbook.model.Account;
import com.cg.passbook.model.Transactions;
import com.cg.passbook.service.PassbookMaintenanceService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class PassbookController {
	Logger logger = LoggerFactory.getLogger(PassbookController.class);

	@Autowired
	private PassbookMaintenanceService service;
	/******************************************
    - Method Name      : accountSummary
    - Input Parameters : accountId, startDate, endDate
    - Return type      : list
    - End Point Url    : /accountSummary
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 15-08-2020
    - Description      : Listing all the transactions between 2 given dates.
     *******************************************/
	
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")
	public ResponseEntity<List<Transactions>> accountSummary(@PathVariable String accountId, @PathVariable Date startDate, @PathVariable Date endDate) 
	{
		List<Transactions> list = service.accountSummary(accountId, startDate, endDate);
		logger.info("Account Summary");
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
		}
		
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Please enter Valid details")
	@ExceptionHandler({Exception.class})
	//this is the handle exception method
	public void handleException() {
		
	}
	
	/******************************************
    - Method Name      : accountValidation
    - Input Parameters : accountId
    - Return type      : string
    - End Point Url    : /accountValidation
    -Request Method Type: Getmapping
    - Author           : Capgemini
    - Creation Date    : 15-08-2020
    - Description      : Validating accountId whether is is present or not.
     ******************************************/
	
	@GetMapping("/accountValidation/{accountId}")
	
	public boolean accountValidation(@PathVariable("accountId") String accountId) {
		return service.accountValidation(accountId);
	}
	/******************************************
    - Method Name      : updatePassbook
    - Input Parameters : accountId
    - Return type      : list
    - End Point Url    : /updatePassbook
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 15-08-2020
    - Description      : Fetching the transactions till last updated date
     ******************************************/
	
		@GetMapping("/updatePassbook/{accountId}")
		public  ResponseEntity<List<Transactions>> updatePassbook(@PathVariable("accountId") String accountId)
		{
				List<Transactions> list = service.updatePassbook(accountId);
				return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
			}
		
		/******************************************
	    - Method Name      : saveAccount
	    - Input Parameters : acc Object
	    - Return type      : object 
	    - End Point Url    : /accounts
	    -Request Method Type: PostMapping
	    - Author           : Capgemini
	    - Creation Date    : 15-08-2020
	    - Description      : Adding a user account.
	     ******************************************/
		
		 @PostMapping("/accounts")
		 public ResponseEntity<Object> save(@RequestBody Account acc)
			{
				acc = service.saveAccount(acc);
				return new ResponseEntity<>(HttpStatus.CREATED);
				}
		 /******************************************
		    - Method Name      : saveTransactions
		    - Input Parameters : trans object
		    - Return type      : object 
		    - End Point Url    : /transactions
		    -Request Method Type: PostMapping
		    - Author           : Capgemini
		    - Creation Date    : 15-08-2020
		    - Description      : Adding transactions.
		     ******************************************/
			
		 @PostMapping("/transactions")
		 public ResponseEntity<Object> save(@RequestBody Transactions trans)
			{
				trans = service.saveTransactions(trans);
				return new ResponseEntity<>(HttpStatus.CREATED);
				}
}

