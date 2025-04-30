package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.EmployeeDetailsRepository;
import com.example.application.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService
{
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
}
