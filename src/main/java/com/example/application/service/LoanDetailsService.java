package com.example.application.service;

import java.util.List;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;
import com.example.application.entity.PropertyDetails;

public interface LoanDetailsService {

	String addLoanDetails(LoanDetailsDTO loanDetailsDTO);

	List<LoanDetails> getAllLoanDetails();

}
