package com.pbs;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.passbook.model.Transactions;




@SpringBootTest
class PecuniaPassbookApplicationTests {
	/****************************************************************************************************************************
	- Test Name      : accountSummaryTest
	- Author         : Capgemini 
	- Creation Date  : 17/08/2020
	- Description    : This test is used to check whether data is retrieved from database or not
	****************************************************************************************************************************/
	

	@Test
	public void accountSummaryTest() throws URISyntaxException 
	{
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8200/accountSummary";
		URI uri = new URI(baseUrl);

		ResponseEntity<Transactions> result = restTemplate.getForEntity(uri, Transactions.class);
		Transactions data = result.getBody();
		Assertions.assertEquals(200, result.getStatusCodeValue());
		Assertions.assertNotNull(data);
	}
	

}
