package com.example.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.EmployeeDetailsDTO;
import com.example.application.dto.GuarantorAddressDTO;
import com.example.application.dto.UpdateGuarantorAddressDTO;
import com.example.application.response.ApiResponse;
import com.example.application.service.GuarantorAddressService;

@RestController
@RequestMapping(value = "/api/guarantor")
public class GuarantorAddressController {

	@Autowired
	private GuarantorAddressService guarantorAddressService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GuarantorAddressController.class);
	
	
	@PostMapping
	public ResponseEntity<ApiResponse<String>> addGuarantorAddress(@RequestBody GuarantorAddressDTO guarantorAddressDTO)
	{
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Entry");
		String msg=guarantorAddressService.addGuarantorAddress(guarantorAddressDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{applicantId}")
	public ResponseEntity<ApiResponse<String>> updateGuarantorLocalAddress(@PathVariable Integer applicantId,@RequestBody UpdateGuarantorAddressDTO updateGuarantorAddressDTO)
	{
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Entry");
		String msg=guarantorAddressService.updateGuarantorLocalAddress(applicantId,updateGuarantorAddressDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	

}
