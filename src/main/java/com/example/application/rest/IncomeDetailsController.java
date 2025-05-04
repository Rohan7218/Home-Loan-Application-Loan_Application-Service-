package com.example.application.rest;

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

import com.example.application.dto.IncomeDetailsDTO;
import com.example.application.entity.IncomeDetails;
import com.example.application.response.ApiResponse;
import com.example.application.service.IncomeDetailsService;

@RestController
@RequestMapping(value = "/api/income")
public class IncomeDetailsController 
{
	@Autowired
	private IncomeDetailsService incomeDetailsService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(IncomeDetailsController.class);

	
	@PostMapping(value = "/incomes/{incomeId}")
	public ResponseEntity<ApiResponse<String>> addIncomeDetails(@RequestBody IncomeDetailsDTO incomeDetailsDTO, @PathVariable Integer incomeId)
	{
		LOGGER.info("IncomeDetailsController : PostMapping : addincomeDetails : Entry");
		String msg=incomeDetailsService.addIncomeDetails(incomeDetailsDTO, incomeId);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("IncomeDetailsController : PostMapping : addincomeDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/incomes/{incomeId}")
	public ResponseEntity<ApiResponse<String>> updateIncomeDetails(@RequestBody IncomeDetailsDTO incomeDetailsDTO ,@PathVariable Integer incomeId)
	{
		LOGGER.info("IncomeDetailsController : PutMapping : updateIncomeDetails : Entry");
		String msg=incomeDetailsService.updateIncomeDetails(incomeDetailsDTO, incomeId);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("IncomeDetailsController : PutMapping : updateIncomeDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/incomes/{incomeId}")
	public ResponseEntity<ApiResponse<Object>> getIncomeDetails(@PathVariable Integer incomeId)
	{
		LOGGER.info("IncomeDetailsController : GetMapping : getIncomeDetails : Entry");
		IncomeDetails incomeDetails=incomeDetailsService.getIncomeDetails(incomeId);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(incomeDetails);
		LOGGER.info("IncomeDetailsController : GetMapping : getIncomeDetails : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);
	}
	
	
	
	
	
}
