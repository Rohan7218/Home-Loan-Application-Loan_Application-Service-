package com.example.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.EmployeeProfile;
import com.example.application.dto.defencePersonnelEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NonSalaried_Details")
public class NonSalaried 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="nonSalaried_Id")
	@Id
	private Integer nonSalariedId;
	
	@Column(name = "Total_Business_Experiece_In_Year")
	private Integer totalBusinessExperienceInYears;
	
	@Column(name = "Total_Business_Experiece_In_Months")
	private Integer totalBusinessExperienceInMonths;
	
	@Column(name = "Gross_Monthly_Name")
	private Double grossMonthlyIncome;
	
	@Column(name = "Net_Monthly_Income")
	private Double netMonthlyIncome;
	
	@Column(name = "Business_Name")
	private String businessName;
	
	@Column(name = "MobileNumber")
	private Long mobileNo;
	
	@Column(name = "Full_Name")
	private String fullname;
	
	@Column(name = "Industy_Name")
	private String industryName; 
	
	@Column(name = "Office_Address_1")
	private String officeAddress1;
	
	@Column(name = "Office_Address_2")
	private String officeAddress2;				
	
	@Column(name = "Village")
	private String village;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "District")
	private String district;
	
	@Column(name = "Pincode")
	private Integer pincode;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Telephone_Number")
	private Long telephoneNo;
		
	@Enumerated(EnumType.STRING)
	@Column(name = "Deference_Name")
	private defencePersonnelEnum defence;
}
