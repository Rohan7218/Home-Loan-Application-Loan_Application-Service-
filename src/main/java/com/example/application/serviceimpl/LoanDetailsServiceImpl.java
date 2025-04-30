package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.LoanDetailsRepository;
import com.example.application.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService
{
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;
}
