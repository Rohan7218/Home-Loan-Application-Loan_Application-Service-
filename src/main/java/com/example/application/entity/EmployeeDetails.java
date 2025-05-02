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

import com.example.application.dto.EmployeeProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee_Details")
public class EmployeeDetails 
{
	@Id
	@SequenceGenerator(name = "EmployeeDetails_ID", sequenceName = "EmployeeDetails_ID", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "EmployeeDetails_ID")
	@Column(name = "Employee_ID")
	private Integer employeeID;
	
	@Column(name = "Employee_FirstName")
	private String employeeFirstName;
	
	@Column(name = "Employee_MiddleName")
	private String employeeMiddleName;

	@Column(name = "Employee_LastName")
	private String employeeLastName;

	@Column(name = "Employee_EmailID")
	private String emailId;

	@Column(name = "Employee_contactNo")
	private Long contactNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Employee_Profile")
	private EmployeeProfile employeeProfile;
	
	@Column(name = "Password")
	private String password;
	
}
