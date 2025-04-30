package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.ApplicantDetailsService;

@RestController
@RequestMapping(value = "/api/applicant")
public class ApplicantDetailsController 
{
	@Autowired
	private ApplicantDetailsService applicantDetailsService;
}
