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

import com.example.application.dto.GuarantorAddressDTO;
import com.example.application.dto.GuarantorDetailsDTO;
import com.example.application.dto.UpdateGuarantorDetailsDTO;
import com.example.application.entity.GuarantorDetails;
import com.example.application.response.ApiResponse;
import com.example.application.service.GuarantorDetailsService;

@RestController
@RequestMapping(value = "/api/guarantors")
public class GuarantorDetailsController 
{
	@Autowired
	private GuarantorDetailsService guarantorDetailsService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GuarantorDetailsController.class);
	

	@PostMapping
	public ResponseEntity<ApiResponse<String>> addGuarantorDetails(@RequestBody GuarantorDetailsDTO guarantorDetailsDTO)
	{
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Entry");
		String msg=guarantorDetailsService.addGuarantorDetails(guarantorDetailsDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{applicantId}")
	public ResponseEntity<ApiResponse<Object>> getGuarantorDetails(@PathVariable Integer applicantId)
	{
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Entry");
		GuarantorDetails guarantorDetails=guarantorDetailsService.getGuarantorDetails(applicantId);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(guarantorDetails);
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{applicantId}")
	public ResponseEntity<ApiResponse<String>> updateGuarantorDetails(@PathVariable Integer applicantId,@RequestBody UpdateGuarantorDetailsDTO updateGuarantorDetailsDTO)
	{
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Entry");
		String msg=guarantorDetailsService.updateGuarantorDetails(applicantId,updateGuarantorDetailsDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("GuarantorAddressService : PostMapping : addGuarantorAddress : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
}
