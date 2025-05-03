package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.IncomeDetailsDTO;
import com.example.application.response.ApiResponse;
import com.example.application.service.IncomeDetailsService;

@RestController
@RequestMapping(value = "/api/income")
public class IncomeDetailsController 
{
	@Autowired
	private IncomeDetailsService incomeDetailsService;
	
	@PostMapping(value = "/incomes")
	public ResponseEntity<ApiResponse<String>> incomeDetailsService(@RequestBody IncomeDetailsDTO incomeDetailsDTO)
	{
		String msg=incomeDetailsService.incomeDetailsService(incomeDetailsDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
}
