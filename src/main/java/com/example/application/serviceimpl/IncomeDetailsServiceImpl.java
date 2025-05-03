package com.example.application.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.IncomeDetailsDTO;
import com.example.application.dto.OccupationEnum;
import com.example.application.entity.IncomeDetails;
import com.example.application.entity.LoanDetails;
import com.example.application.entity.NonSalaried;
import com.example.application.entity.Salaried;
import com.example.application.repository.IncomeDetailsRepository;
import com.example.application.repository.NonSalariedIncomeDetailsRepository;
import com.example.application.repository.SalariedIncomeDetailsRepository;
import com.example.application.service.IncomeDetailsService;
import com.netflix.discovery.converters.Auto;
@Service
public class IncomeDetailsServiceImpl implements IncomeDetailsService
{
	@Autowired
	private SalariedIncomeDetailsRepository salariedIncomeDetailsRepository;
	
	@Autowired
	private IncomeDetailsRepository incomeDetailsRepository;
	
	@Autowired
	private NonSalariedIncomeDetailsRepository nonSalariedIncomeDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String incomeDetailsService(IncomeDetailsDTO incomeDetailsDTO) 
	{
		if(incomeDetailsDTO.getOccupation().equals(OccupationEnum.SALARIED) ||incomeDetailsDTO.getOccupation().equals(OccupationEnum.PENSIONER))
		{
			Salaried salaried = modelMapper.map(incomeDetailsDTO, Salaried.class);
			
			IncomeDetails incomeDetails=new IncomeDetails();
								   incomeDetails.setSalariedId(salaried);
								   incomeDetails.setOccupation(incomeDetailsDTO.getOccupation());
			
			incomeDetailsRepository.save(incomeDetails);
			
			return "!!!...Salaried Details Saved SuccessFully...!!!";
			
		}
		else
		{
			NonSalaried nonSalaried = modelMapper.map(incomeDetailsDTO, NonSalaried.class);
//			nonSalariedIncomeDetailsRepository.save(nonSalaried);
			
			IncomeDetails incomeDetails=new IncomeDetails();
			   					   incomeDetails.setNonSalariedId(nonSalaried);
			   					   incomeDetails.setOccupation(incomeDetailsDTO.getOccupation());
			   					   
			 incomeDetailsRepository.save(incomeDetails);
	
			return "!!!...Non Salaried Details Saved SuccessFully...!!!";
		}
		
	}
}
