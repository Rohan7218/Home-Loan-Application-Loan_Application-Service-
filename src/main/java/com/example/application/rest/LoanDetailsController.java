package com.example.application.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;

import com.example.application.response.ApiResponse;
import com.example.application.service.LoanDetailsService;

@RestController
@RequestMapping(value = "/api/loan")
public class LoanDetailsController {
	@Autowired
	private LoanDetailsService loanDetailsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanDetailsController.class);


	@PostMapping(value = "/loanDetails")
	public ResponseEntity<String> addLoanDetails(@RequestBody LoanDetailsDTO loanDetailsDTO) {
		LOGGER.info("LoanDetailsController : PostMapping : addLoanDetails : Entry");

		String msg = loanDetailsService.addLoanDetails(loanDetailsDTO);
		if (msg != null) {
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		LOGGER.info("LoanDetailsController : PostMapping : addLoanDetails : Exit");
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/loanDetails")
	public ResponseEntity<ApiResponse<Object>> getAllLoanDetails() {
		LOGGER.info("LoanDetailsController : GetMapping : getAllLoanDetails : Entry");
		List<LoanDetails> loanDetailList = loanDetailsService.getAllLoanDetails();
		ApiResponse<Object> apiResponse = new ApiResponse<Object>(loanDetailList);
		LOGGER.info("LoanDetailsController : GetMapping : getAllLoanDetails : Exit");

		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);

	}

	@GetMapping(value = "/loanDetails/{applicantId}")
	public ResponseEntity<ApiResponse<Object>> getLoanDetail(@PathVariable Integer applicantId) {
		LOGGER.info("LoanDetailsController : GetMapping : getAllLoanDetails : Entry");
		LoanDetails loanDetails = loanDetailsService.getLoanDetail(applicantId);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(loanDetails);
		LOGGER.info("LoanDetailsController : GetMapping : getAllLoanDetails : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse,HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/propertyDetails/{applicantId}")
	public ResponseEntity<ApiResponse<String>> updateLoanDetails(@RequestBody LoanDetailsDTO loanDetailsDTO , @PathVariable Integer applicantId){
		LOGGER.info("LoanDetailsController : PutMapping : updateLoanDetails : Entry");
		String msg  =  loanDetailsService.updateLoanDetails(loanDetailsDTO , applicantId);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("LoanDetailsController : PutMapping : updateLoanDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse,HttpStatus.OK);

	}
	
	

}
