package com.example.application.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.IncomeDetailsDTO;
import com.example.application.dto.OccupationEnum;
import com.example.application.entity.IncomeDetails;
import com.example.application.entity.NonSalaried;
import com.example.application.entity.Salaried;
import com.example.application.exceptionhandling.CustomeException;
import com.example.application.repository.IncomeDetailsRepository;
import com.example.application.repository.NonSalariedIncomeDetailsRepository;
import com.example.application.repository.SalariedIncomeDetailsRepository;
import com.example.application.service.IncomeDetailsService;
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
	
	private static final Logger LOGGER=LoggerFactory.getLogger(IncomeDetailsServiceImpl.class);

	
	@Override
	public String addIncomeDetails(IncomeDetailsDTO incomeDetailsDTO, Integer incomeId) 
	{
		LOGGER.debug("IncomeDetailsServiceImpl : addIncomeDetails : Entry");
		if(incomeDetailsRepository.findById(incomeId).isPresent())
		{
			IncomeDetails incomeDetails = incomeDetailsRepository.findById(incomeId).get();
			
			if(incomeDetailsDTO.getOccupation().equals(OccupationEnum.SALARIED) ||incomeDetailsDTO.getOccupation().equals(OccupationEnum.PENSIONER))
			{
				Salaried salaried = modelMapper.map(incomeDetailsDTO, Salaried.class);
			
					
				incomeDetails.setSalariedId(salaried);
				incomeDetails.setOccupation(incomeDetailsDTO.getOccupation());
				
				incomeDetailsRepository.save(incomeDetails);
				
				LOGGER.debug("IncomeDetailsServiceImpl : addIncomeDetails : Exit");
				return "!!!...Salaried Details Saved SuccessFully...!!!";
				
			}
			else
			{	
				NonSalaried nonSalaried = modelMapper.map(incomeDetailsDTO, NonSalaried.class);
				
				   					   incomeDetails.setNonSalariedId(nonSalaried);
				   					   incomeDetails.setOccupation(incomeDetailsDTO.getOccupation());
				   					   
				 incomeDetailsRepository.save(incomeDetails);
		
					LOGGER.debug("IncomeDetailsServiceImpl : addIncomeDetails : Exit");
				return "!!!...Non Salaried Details Saved SuccessFully...!!!";
			}
		}

		else
		{
			LOGGER.debug("IncomeDetailsServiceImpl : addIncomeDetails : Exit");
			throw new CustomeException("!!!...Invalid Income Id...!!!");
		}
	}
	
	
	@Override
	public String updateIncomeDetails(IncomeDetailsDTO incomeDetailsDTO, Integer incomeId) 
	{
		LOGGER.debug("IncomeDetailsServiceImpl : updateIncomeDetails : Entry");
		if(incomeDetailsRepository.findById(incomeId).isPresent())
		{
			IncomeDetails existedIncomeDetails = incomeDetailsRepository.findById(incomeId).get();
		
			if(existedIncomeDetails.getOccupation().equals(OccupationEnum.SALARIED) ||existedIncomeDetails.getOccupation().equals(OccupationEnum.PENSIONER))
			{
				Salaried existedSalaried = salariedIncomeDetailsRepository.findById(existedIncomeDetails.getSalariedId().getSalariedId()).get();
				
				if(incomeDetailsDTO.getEmployeeFullName()!=null)
				{
					existedSalaried.setEmployeeFullName(incomeDetailsDTO.getEmployeeFullName());
				}
				if(incomeDetailsDTO.getOrganizationType()!=null)
				{
					existedSalaried.setOrganizationType(incomeDetailsDTO.getOrganizationType());
				}
				if(incomeDetailsDTO.getEmployeementStatus()!=null)
				{
					existedSalaried.setEmployeementStatus(incomeDetailsDTO.getEmployeementStatus());
				}
				if(incomeDetailsDTO.getTotalWorkExperienceInMonths()!=null)
				{
					existedSalaried.setTotalWorkExperienceInMonths(incomeDetailsDTO.getTotalWorkExperienceInMonths());
				}
				if(incomeDetailsDTO.getTotalWorkExperienceInYears()!=null)
				{
					existedSalaried.setTotalWorkExperienceInYears(incomeDetailsDTO.getTotalWorkExperienceInYears());
				}
				if(incomeDetailsDTO.getPensionType()!=null)
				{
					existedSalaried.setPensionType(incomeDetailsDTO.getPensionType());
				}
				if(incomeDetailsDTO.getIndustryName()!=null)
				{
					existedSalaried.setJobIndustryName(incomeDetailsDTO.getIndustryName());
				}
				if(incomeDetailsDTO.getEmployeeGrossMonthlyIncome()!=null)
				{
					existedSalaried.setEmployeeGrossMonthlyIncome(incomeDetailsDTO.getEmployeeGrossMonthlyIncome());
				}
				if(incomeDetailsDTO.getEmployeeNetMonthlyIncome()!=null)
				{
					existedSalaried.setEmployeeNetMonthlyIncome(incomeDetailsDTO.getEmployeeNetMonthlyIncome());
				}
				if(incomeDetailsDTO.getCheckOff()!=null)
				{
					existedSalaried.setCheckOff(incomeDetailsDTO.getCheckOff());
				}

				salariedIncomeDetailsRepository.save(existedSalaried);
				LOGGER.debug("IncomeDetailsServiceImpl : updateIncomeDetails : Exit");
				return "!!...Salaried Details Updated Succesfully...!!";
			}
			else
			{	
			NonSalaried existedNonSalaried = nonSalariedIncomeDetailsRepository.findById(existedIncomeDetails.getNonSalariedId().getNonSalariedId()).get();
				if(incomeDetailsDTO.getBusinessName()!=null)
				{
					existedNonSalaried.setBusinessName(incomeDetailsDTO.getBusinessName());
				}
				if(incomeDetailsDTO.getTotalBusinessExperienceInMonths()!=null)
				{
					existedNonSalaried.setTotalBusinessExperienceInMonths(incomeDetailsDTO.getTotalBusinessExperienceInMonths());
				}
				if(incomeDetailsDTO.getTotalBusinessExperienceInYears()!=null)
				{
					existedNonSalaried.setTotalBusinessExperienceInYears(incomeDetailsDTO.getTotalBusinessExperienceInYears());
				}
				if(incomeDetailsDTO.getGrossMonthlyIncome()!=null)
				{
					existedNonSalaried.setGrossMonthlyIncome(incomeDetailsDTO.getGrossMonthlyIncome());
				}
				if(incomeDetailsDTO.getNetMonthlyIncome()!=null)
				{
					existedNonSalaried.setNetMonthlyIncome(incomeDetailsDTO.getNetMonthlyIncome());
				}
				if(incomeDetailsDTO.getIndustryName()!=null)
				{
					existedNonSalaried.setIndustryName(incomeDetailsDTO.getIndustryName());
				}
				if(incomeDetailsDTO.getOfficeAddress1()!=null)
				{
					existedNonSalaried.setOfficeAddress1(incomeDetailsDTO.getOfficeAddress1());
				}
				if(incomeDetailsDTO.getOfficeAddress2()!=null)
				{
					existedNonSalaried.setOfficeAddress2(incomeDetailsDTO.getOfficeAddress2());
				}
				if(incomeDetailsDTO.getVillage()!=null)
				{
					existedNonSalaried.setVillage(incomeDetailsDTO.getVillage());
				}
				if(incomeDetailsDTO.getCity()!=null)
				{
					existedNonSalaried.setCity(incomeDetailsDTO.getCity());
				}
				if(incomeDetailsDTO.getDistrict()!=null)
				{
					existedNonSalaried.setDistrict(incomeDetailsDTO.getDistrict());
				}	
				if(incomeDetailsDTO.getPincode()!=null)
				{
					existedNonSalaried.setPincode(incomeDetailsDTO.getPincode());
				}
				if(incomeDetailsDTO.getState()!=null)
				{
					existedNonSalaried.setState(incomeDetailsDTO.getState());
				}
				if(incomeDetailsDTO.getCountry()!=null)
				{
					existedNonSalaried.setCountry(incomeDetailsDTO.getCountry());
				}
				if(incomeDetailsDTO.getTelephoneNo()!=null)
				{
					existedNonSalaried.setTelephoneNo(incomeDetailsDTO.getTelephoneNo());
				}
				if(incomeDetailsDTO.getMobileNo()!=null)
				{
					existedNonSalaried.setMobileNo(incomeDetailsDTO.getMobileNo());
				}
				if(incomeDetailsDTO.getDefence()!=null)
				{
					existedNonSalaried.setDefence(incomeDetailsDTO.getDefence());
				}
				
			nonSalariedIncomeDetailsRepository.save(existedNonSalaried);
			LOGGER.debug("IncomeDetailsServiceImpl : updateIncomeDetails : Exit");
			return  "!!...Non_salaried Details Updated Succesfully...!!";	
			}
		}
		else
		{
			LOGGER.debug("IncomeDetailsServiceImpl : updateIncomeDetails : Exit");
			throw new CustomeException("!!!...For Given Income Id Record Is Not Present...!!!");
		}
	}

	@Override
	public IncomeDetails getIncomeDetails(Integer incomeId) {
		LOGGER.debug("IncomeDetailsServiceImpl : getIncomeDetails : Entry");
		if(incomeDetailsRepository.findById(incomeId).isPresent())
		{
			IncomeDetails existedIncomeDetails = incomeDetailsRepository.findById(incomeId).get();
			LOGGER.debug("IncomeDetailsServiceImpl : getIncomeDetails : Exit");
			return existedIncomeDetails;
		}
		else
		{
			LOGGER.debug("IncomeDetailsServiceImpl : getIncomeDetails : Exit");
			throw new CustomeException("!!!...For Given Income Id Record Is Not Present...!!!");
		}
	}
		
	
	
		
	
	
	
	
	

	
	
	
	
}
