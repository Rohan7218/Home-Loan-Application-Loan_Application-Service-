package com.example.application.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.application.dto.LoanSanctionDTO;
import com.example.application.response.ApiResponse;

@FeignClient(name = "loan-sanction-service")
public interface LoanSanctionApiFeignClient 
{
	@PostMapping(value = "/api/loansanction")
	public ResponseEntity<ApiResponse<String>> addSanctionDetails(@RequestBody LoanSanctionDTO loanSanctionDTO);
}
