package com.example.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.CheckOffAvailableEnum;
import com.example.application.dto.EmployeementStatusEnum;
import com.example.application.dto.OrganizationTypeEnum;
import com.example.application.dto.PensionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Salaried_Details")
public class Salaried 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Salaried_Id")
	@Id
	private Integer salariedId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Organization_Type")
	private OrganizationTypeEnum organizationType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Employeement_Status")
	private EmployeementStatusEnum employeementStatus;
	
	@Column(name = "Total_Work_Experiece_In_Year")
	private Integer totalWorkExperienceInYears;
	
	@Column(name = "Total_Work_Experiece_In_Months")
	private Integer totalWorkExperienceInMonths;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Pension_Type")
	private PensionTypeEnum pensionType;
	
	@Column(name = "Employee_Full_Name")
	private String employeeFullName;
	
	@Column(name = "Industy_Name")
	private String jobIndustryName;
	
	@Column(name = "Gross_Monthly_Name")
	private Double employeeGrossMonthlyIncome;
	
	@Column(name = "Net_Monthly_Income")
	private Double employeeNetMonthlyIncome;

	@Enumerated(EnumType.STRING)
	@Column(name = "CheckOff_Available")
	private CheckOffAvailableEnum checkOff;
	
	
	
	
}
