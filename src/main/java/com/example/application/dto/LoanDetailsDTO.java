package com.example.application.dto;
import lombok.Data;

@Data
public class LoanDetailsDTO {
	
	private LoanPurposeEnum loanPurpose;
	
	private String bankName;

	private String branchName;
	
	private String IFSC_Code;
	
	private Integer tenure;
	
	private Integer moratorium;
	
	private Long requestedLoanAmount;
	
}
