package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.LoanDetailsService;

@RestController
@RequestMapping(value = "/api/loan")
public class LoanDetailsController 
{
	@Autowired
	private LoanDetailsService loanDetailsService;
}
