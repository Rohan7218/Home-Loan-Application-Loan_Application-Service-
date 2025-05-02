package com.example.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.response.ApiResponse;
import com.example.application.service.ApplicantDetailsService;

@RestController
@RequestMapping(value = "/api/applicant")
public class ApplicantDetailsController 
{
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicantDetailsController.class);
	
	@Autowired
	private ApplicantDetailsService applicantDetailsService;
	
	@PostMapping(value = "/applicants")
	public ResponseEntity<ApiResponse<String>> addApplicantDetailsService()
	{
		LOGGER.info("ApplicantDetailsController : PostMapping : addApplicantDetailsService : Entry");
		String msg=applicantDetailsService.addApplicantDetailsService();
		ApiResponse<String> apiResponse=new ApiResponse<String>(msg);
		LOGGER.info("ApplicantDetailsController : PostMapping : addApplicantDetailsService : Exit");
		return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.CREATED);
	}
}
