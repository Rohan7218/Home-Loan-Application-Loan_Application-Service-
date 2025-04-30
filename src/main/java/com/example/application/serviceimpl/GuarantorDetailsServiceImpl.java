package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.GuarantorDetailsRespotory;
import com.example.application.service.GuarantorDetailsService;

@Service
public class GuarantorDetailsServiceImpl implements GuarantorDetailsService
{
	@Autowired
	private GuarantorDetailsRespotory guarantorDetailsRespotory;
}
