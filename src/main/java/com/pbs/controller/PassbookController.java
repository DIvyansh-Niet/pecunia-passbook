package com.pbs.controller;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pbs.model.Transactions;
import com.pbs.service.PassbookMaintenanceService;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class PassbookController {

	@Autowired
	private PassbookMaintenanceService service;

	
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")
	public ResponseEntity<List<Transactions>> accountSummary(@PathVariable String accountId, @PathVariable Date startDate, @PathVariable Date endDate) 
	{
		List<Transactions> list = service.accountSummary(accountId, startDate, endDate);
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
		}
		
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Please enter Valid details")
	@ExceptionHandler({Exception.class})
	public void handleException() {
		
	}
	
	//Validating accountId whether is is present or not.
	@GetMapping("/accountValidation/{accountId}")
	public boolean accountValidation(@PathVariable("accountId") String accountId) {
		return service.accountValidation(accountId);
	}

	//Fetching the transactions till last updated date
		@GetMapping("/updatePassbook/{accountId}")
		public  ResponseEntity<List<Transactions>> updatePassbook(@PathVariable("accountId") String accountId)
		{
				List<Transactions> list = service.updatePassbook(accountId);
				return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
			}
			
}

