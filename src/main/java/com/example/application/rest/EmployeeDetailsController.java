package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.EmployeeDetailsService;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeDetailsController 
{
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
}
