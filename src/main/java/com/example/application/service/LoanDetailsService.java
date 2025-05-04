package com.example.application.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;

public interface LoanDetailsService {

	String addLoanDetails(LoanDetailsDTO loanDetailsDTO,@PathVariable  Integer loanDetailsID);

	List<LoanDetails> getAllLoanDetails();

	LoanDetails getLoanDetail(Integer applicantId);

	String updateLoanDetails(LoanDetailsDTO loanDetailsDTO, Integer applicantId);

}
