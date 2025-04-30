package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.LedgerDetailsService;

@RestController
@RequestMapping(value = "/api/ledger")
public class LedgerDetailsController 
{
	@Autowired
	private LedgerDetailsService ledgerDetailsService;
}
