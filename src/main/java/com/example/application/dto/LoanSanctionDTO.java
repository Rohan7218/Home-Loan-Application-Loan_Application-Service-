package com.example.application.dto;

import lombok.Data;

@Data
public class LoanSanctionDTO 
{
	private String applicantName;
	
	private Long contactNo;
	
	private Integer customerId;
	
	private Integer appllicantId;
	
	private Integer cibilScore;
	
	private Long requestedLoanAmount;
}
