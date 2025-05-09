package com.example.application.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.AccountStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Applicant_Details")
public class ApplicantDetails 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Applicant_Id")
	@Id
	private Integer applicantId;
	
	@Column(name = "Customer_Id")
	private Integer customerId;
	
	@Column(name = "Cibil_Score")
	private Integer cibilScore;
	
	@Column(name = "Email_Id")
	private String emailId;
	
	@Enumerated(EnumType.STRING)
	private AccountStatusEnum accountStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Property_Id")
	private PropertyDetails propertyId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Loan_Id")
	private LoanDetails loanId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Guarantor_Id")
	private GuarantorDetails guarantorId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Income_Id")
	private IncomeDetails incomeId;
	
	
	
	

}
