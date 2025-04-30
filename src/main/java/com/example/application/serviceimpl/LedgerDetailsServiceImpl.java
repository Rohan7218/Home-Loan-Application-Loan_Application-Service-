package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.LedgerDetailsRepository;
import com.example.application.service.LedgerDetailsService;

@Service
public class LedgerDetailsServiceImpl implements LedgerDetailsService
{
	@Autowired
	private LedgerDetailsRepository ledgerDetailsRepository;
}
