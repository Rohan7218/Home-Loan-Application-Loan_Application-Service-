package com.example.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;
import com.example.application.entity.PropertyDetails;
import com.example.application.response.ApiResponse;
import com.example.application.service.LoanDetailsService;

@RestController
@RequestMapping(value = "/api/loan")
public class LoanDetailsController 
{
	@Autowired
	private LoanDetailsService loanDetailsService;
	
	@PostMapping(value = "/addLoanDetails")
	public ResponseEntity<String> addLoanDetails(@RequestBody LoanDetailsDTO loanDetailsDTO){
		
		String msg =	loanDetailsService.addLoanDetails(loanDetailsDTO);
		if(msg!=null) {
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/getAllLoanDetails")
	public ResponseEntity<ApiResponse<Object>> getAllLoanDetails(){
		
		List<LoanDetails> loanDetailList  =	loanDetailsService.getAllLoanDetails();
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(loanDetailList);
		return new ResponseEntity<ApiResponse<Object>>(apiResponse,HttpStatus.OK);
		
	}
	
	
}
