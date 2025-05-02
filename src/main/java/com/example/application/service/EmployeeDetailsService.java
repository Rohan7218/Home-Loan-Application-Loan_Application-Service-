package com.example.application.service;

import java.util.List;

import com.example.application.dto.EmployeeDetailsDTO;
import com.example.application.dto.EmployeeDetailsUpdateDTO;
import com.example.application.entity.EmployeeDetails;

public interface EmployeeDetailsService {

	String registerEmployee(EmployeeDetailsDTO employeeDetailsDTO);

	EmployeeDetails getEmployee(Integer employeeID);

	List<EmployeeDetails> getAllEmployee();

	String updateEmployeeDetails(Integer employeeID, EmployeeDetailsUpdateDTO employeeDetailsUpdateDTO);

}
