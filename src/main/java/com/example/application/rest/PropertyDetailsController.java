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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.dto.PropertyDetailsDTO;
import com.example.application.entity.PropertyDetails;
import com.example.application.response.ApiResponse;
import com.example.application.service.PropertyDetailsService;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyDetailsController 
{
	@Autowired
	private PropertyDetailsService propertyDetailsService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PropertyDetailsController.class);

	
	@PostMapping(value = "/propertyDetails")
	public ResponseEntity<ApiResponse<String>> addPropertyDetails(@RequestBody PropertyDetailsDTO propertyDetailsDTO)
	{
		LOGGER.info("PropertyDetailsController : PostMapping : addPropertyDetails : Entry");
		String msg=propertyDetailsService.addPropertyDetails(propertyDetailsDTO);
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("PropertyDetailsController : PostMapping : addPropertyDetails : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/propertyDetails")
	public ResponseEntity<ApiResponse<Object>> getAllPropertyDetails()
	{
		LOGGER.info("PropertyDetailsController : GetMapping : getAllPropertyDetails : Entry");
		List<PropertyDetails> list=propertyDetailsService.getAllPropertyDetails();
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(list);
		LOGGER.info("PropertyDetailsController : GetMapping : getAllPropertyDetails : Exit");
		return new ResponseEntity<ApiResponse<Object>>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping(value = "/propertyDetails/{customerId}")
	public ResponseEntity<ApiResponse<Object>> getPropertyDetails(@PathVariable Integer customerId)
	{
		LOGGER.info("PropertyDetailsController : GetMapping : getPropertyDetails : Entry");
		PropertyDetails propertyDetails=propertyDetailsService.getPropertyDetails(customerId);
		ApiResponse<Object> apiResponse=new ApiResponse<Object>(propertyDetails);
		LOGGER.info("PropertyDetailsController : GetMapping : getPropertyDetails : Exit");	
		return new ResponseEntity<ApiResponse<Object>>(apiResponse,HttpStatus.OK);
	}
	
	
	 
	
}
