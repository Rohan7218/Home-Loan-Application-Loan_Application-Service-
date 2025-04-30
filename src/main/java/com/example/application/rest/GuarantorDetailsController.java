package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.GuarantorDetailsService;

@RestController
@RequestMapping(value = "/api/guarantor")
public class GuarantorDetailsController 
{
	@Autowired
	private GuarantorDetailsService guarantorDetailsService;
}
