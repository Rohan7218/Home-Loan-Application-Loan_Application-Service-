package com.example.application.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class IncomeDetailsDTO 
{
	@Enumerated(EnumType.STRING)
	private OccupationEnum occupation;
	
	@Enumerated(EnumType.STRING)
	private OrganizationTypeEnum organizationType;
	
	@Enumerated(EnumType.STRING)
	private EmployeementStatusEnum employeementStatus;
	
	private Integer totalWorkExperienceInYears;
	
	private Integer totalWorkExperienceInMonths;
	
	@Enumerated(EnumType.STRING)
	private PensionTypeEnum pensionType;
	
	private String employeeFullName;
	
	private String jobIndustryName;
	
	private Double employeeGrossMonthlyIncome;
	
	private Double employeeNetMonthlyIncome;

	@Enumerated(EnumType.STRING)
	private CheckOffAvailableEnum checkOff;
	
	private Integer totalBusinessExperienceInYears;

	private Integer totalBusinessExperienceInMonths;
	
	private Double grossMonthlyIncome;
	
	private Double netMonthlyIncome;
	
	private String businessName;
	
	private String industryName; 
	
	private String officeAddress1;
	
	private String officeAddress2;				
	
	private String village;
	
	private String city;
	
	private String district;
	
	private Integer pincode;
	
	private String state;
	
	private String country;
	
	private Long telephoneNo;
	
	private Long mobileNo;
	
	@Enumerated(EnumType.STRING)
	private defencePersonnelEnum defence;
}
