package com.example.application.service;

import com.example.application.dto.AccountStatusDTO;
import com.example.application.dto.LoanApplicantionCustomerIdDTO;

public interface ApplicantDetailsService {

	String addApplicantDetailsService(LoanApplicantionCustomerIdDTO loanApplicantionCustomerIdDTO);

	String updateApplicantStatus(AccountStatusDTO accountStatusDTO, Integer applicantId);

	

}
