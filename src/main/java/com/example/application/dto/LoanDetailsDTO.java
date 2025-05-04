 package com.example.application.dto;
 
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class LoanDetailsDTO {
	
	@Enumerated(EnumType.STRING)
	private LoanPurposeEnum loanPurpose;
	
	private String bankName;

	private String branchName;
	
	private String IFSC_Code;
	
	private Integer tenure;
	
	private Integer moratorium;
	
	private Long requestedLoanAmount;
	
	private AccountTypeEnum accountType;
	
	private String accountHolderName;
	
	private Long accountNumber;
	
}
