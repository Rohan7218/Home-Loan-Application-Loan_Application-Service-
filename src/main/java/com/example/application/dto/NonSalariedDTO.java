package com.example.application.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class NonSalariedDTO 
{
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
	
	private String fullname;
	
	@Enumerated(EnumType.STRING)
	private defencePersonnelEnum defence;
}
