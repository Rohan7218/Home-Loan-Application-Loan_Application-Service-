package com.example.application.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class SalariedDTO 
{
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
}
