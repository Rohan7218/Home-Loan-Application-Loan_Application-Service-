package com.example.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Applicant_Id")
	private Integer applicantId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_Id")
	private EmployeeDetails employeeId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Property_Id")
	private PropertyDetails propertyId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Loan_Id")
	private LoanDetails loanId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Guarantor_Id")
	private GuarantorDetails guarantorId;
	
	
	
}
