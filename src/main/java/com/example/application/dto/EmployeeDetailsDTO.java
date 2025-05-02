package com.example.application.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class EmployeeDetailsDTO {

	private String employeeFirstName;

	private String employeeMiddleName;

	private String employeeLastName;

	private String emailId;

	private Long contactNo;

	@Enumerated(EnumType.STRING)
	private EmployeeProfile employeeProfile;
	


}
