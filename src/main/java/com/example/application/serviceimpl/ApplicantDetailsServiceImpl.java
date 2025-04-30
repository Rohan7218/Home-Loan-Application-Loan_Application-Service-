package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.service.ApplicantDetailsService;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService
{
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;
}
