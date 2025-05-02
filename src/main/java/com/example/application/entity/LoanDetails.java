package com.example.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.LoanPurposeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "Loan_Details")
public class LoanDetails {

	@Id
	@SequenceGenerator(name = "LoanDetails_ID", sequenceName = "LoanDetails_ID", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "LoanDetails_ID")
	@Column(name = "LoanDetails_ID")
	private Integer LoanDetailsID;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Loan_Purpose")
	private LoanPurposeEnum loanPurpose;
	
	@Column(name = "Bank_Name")
	private String bankName;
	
	@Column(name = "Branch_Name")
	private String branchName;
	
	@Column(name = "IFSC_Code")
	private String IFSC_Code;
	
	@Column(name = "Tenure_years")
	private Integer tenure;
	
	@Column(name = "Monatorium_Period_Years")
	private Integer moratorium;
	
	@Column(name = "Requested_Loan_Amount")
	private Long requestedLoanAmount;

	
	
	
	
	
	
	
	
}
