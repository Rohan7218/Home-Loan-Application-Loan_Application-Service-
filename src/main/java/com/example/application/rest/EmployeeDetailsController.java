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

import com.example.application.dto.EmployeeDetailsDTO;
import com.example.application.dto.EmployeeDetailsUpdateDTO;
import com.example.application.entity.EmployeeDetails;
import com.example.application.response.ApiResponse;
import com.example.application.service.EmployeeDetailsService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeDetailsController 
{
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeDetailsController.class);

	
	@PostMapping
	public ResponseEntity<ApiResponse<String>> registerEmployee(@RequestBody EmployeeDetailsDTO employeeDetailsDTO)
	{
		LOGGER.info("EmployeeDetailsController : PostMapping : registerEmployee : Entry");
		String msg=employeeDetailsService.registerEmployee(employeeDetailsDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("EmployeeDetailsController : PostMapping : registerEmployee : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/employees/{employeeID}")
	public ResponseEntity<ApiResponse<Object>> getEmployee(@PathVariable Integer employeeID)
	{
		LOGGER.info("EmployeeDetailsController : GetMapping : getEmployee : Entry");
		EmployeeDetails employeeDetails=employeeDetailsService.getEmployee(employeeID);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(employeeDetails);
		LOGGER.info("EmployeeDetailsController : GetMapping : getEmployee : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/employees")
	public ResponseEntity<ApiResponse<Object>> getAllEmployee()
	{
		LOGGER.info("EmployeeDetailsController : GetMapping : getAllEmployee : Entry");
		List<EmployeeDetails> list=employeeDetailsService.getAllEmployee();
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(list);
		LOGGER.info("EmployeeDetailsController : GetMapping : getAllEmployee : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.OK);
	}
	
	@PutMapping(value = "/employees/{employeeID}")
	public ResponseEntity<ApiResponse<String>> updateEmployeeDetails(@PathVariable Integer employeeID,@RequestBody EmployeeDetailsUpdateDTO employeeDetailsUpdateDTO)
	{
		LOGGER.info("EmployeeDetailsController : PutMapping : updateEmployeeDetails : Entry");
		String msg=employeeDetailsService.updateEmployeeDetails(employeeID,employeeDetailsUpdateDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("EmployeeDetailsController : PutMapping : updateEmployeeDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.OK);
	
	}
}

