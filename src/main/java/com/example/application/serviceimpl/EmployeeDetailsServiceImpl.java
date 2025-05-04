package com.example.application.serviceimpl;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.EmployeeDetailsDTO;
import com.example.application.dto.EmployeeDetailsUpdateDTO;
import com.example.application.entity.EmployeeDetails;
import com.example.application.exceptionhandling.CustomeException;
import com.example.application.repository.EmployeeDetailsRepository;
import com.example.application.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService
{
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeDetailsServiceImpl.class);

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public String registerEmployee(EmployeeDetailsDTO employeeDetailsDTO)
	{
		LOGGER.debug("EmployeeDetailsServiceImpl : registerEmployee : Entry");
		EmployeeDetails employeeDetails = modelMapper.map(employeeDetailsDTO, EmployeeDetails.class);
		employeeDetails.setPassword(generatePassword());
		employeeDetailsRepository.save(employeeDetails);
		LOGGER.debug("EmployeeDetailsServiceImpl : registerEmployee : Exit");
		return "Employee Registered Succesfully";
	}
	
	
	@Override
	public EmployeeDetails getEmployee(Integer employeeID) 
	{
		Optional<EmployeeDetails> optional = employeeDetailsRepository.findById(employeeID);
		if(optional.isPresent())
		{
			LOGGER.debug("EmployeeDetailsServiceImpl : getEmployee : Entry");
			EmployeeDetails employeeDetails = optional.get();
			LOGGER.debug("EmployeeDetailsServiceImpl : getEmployee : Exit");
			return employeeDetails;
		}
		else
		{
			throw new CustomeException("!!!...No Employee Found for Given Employee Id...!!!");
		}
		
	}
	
	@Override
	public List<EmployeeDetails> getAllEmployee() 
	{
		LOGGER.debug("EmployeeDetailsServiceImpl : getEmployee : Entry");
		List<EmployeeDetails> list = employeeDetailsRepository.findAll();
		if(!list.isEmpty())
		{
			LOGGER.debug("EmployeeDetailsServiceImpl : getEmployee : Exit");
			return list;
		}
		else
		{
			throw new CustomeException("!!!...No Employees Record Found....!!!");
		}
	}
	
	@Override
	public String updateEmployeeDetails(Integer employeeID, EmployeeDetailsUpdateDTO employeeDetailsUpdateDTO) {
		LOGGER.debug("EmployeeDetailsServiceImpl : updateEmployeeDetails : Entry");
		Optional<EmployeeDetails> optional = employeeDetailsRepository.findById(employeeID);
		if(optional.isPresent())
		{
				EmployeeDetails employeeDetails = optional.get();
				if(employeeDetailsUpdateDTO.getEmployeeFirstName()!=null)
				{
					employeeDetails.setEmployeeFirstName(employeeDetailsUpdateDTO.getEmployeeFirstName());
				}
				if(employeeDetailsUpdateDTO.getEmployeeMiddleName()!=null)
				{
					employeeDetails.setEmployeeMiddleName(employeeDetailsUpdateDTO.getEmployeeMiddleName());
				}
				if(employeeDetailsUpdateDTO.getEmployeeLastName()!=null)
				{
					employeeDetails.setEmployeeLastName(employeeDetailsUpdateDTO.getEmployeeLastName());
				}
				if(employeeDetailsUpdateDTO.getEmailId()!=null)
				{
					employeeDetails.setEmailId(employeeDetailsUpdateDTO.getEmailId());
				}
				if(employeeDetailsUpdateDTO.getContactNo()!=null)
				{
					employeeDetails.setContactNo(employeeDetailsUpdateDTO.getContactNo());
				}
				employeeDetailsRepository.save(employeeDetails);
				LOGGER.debug("EmployeeDetailsServiceImpl : updateEmployeeDetails : Exit");
				return "Employee Details Updated Succesfully ID :-"+" "+employeeID;
		}
		else
		{
			LOGGER.debug("EmployeeDetailsServiceImpl : updateEmployeeDetails : Exit");
			throw new CustomeException("!!!...For Given Employee Id No Employee Found....!!!");
		}
	}
	
	public static String generatePassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    SecureRandom random = new SecureRandom();
	    StringBuilder password = new StringBuilder(6);

	    for (int i = 0; i < 6; i++) {
	        int index = random.nextInt(characters.length());
	        password.append(characters.charAt(index));
	    }
	    return password.toString();
	}

	
}
