package com.example.application.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.LoanApplicantionCustomerIdDTO;
import com.example.application.dto.LoanSanctionDTO;
import com.example.application.dto.OccupationEnum;
import com.example.application.config.LoanSanctionApiFeignClient;
import com.example.application.dto.AccountStatusDTO;
import com.example.application.dto.AccountStatusEnum;
import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.GuarantorDetails;
import com.example.application.entity.GuarantorLocalAddress;
import com.example.application.entity.GuarantorPermanentAddress;
import com.example.application.entity.IncomeDetails;
import com.example.application.entity.LoanDetails;
import com.example.application.entity.PropertyDetails;
import com.example.application.exceptionhandling.CustomeException;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.service.ApplicantDetailsService;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService
{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicantDetailsServiceImpl.class);
	
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;
	
	@Autowired
	private LoanSanctionApiFeignClient loanSanctionApiFeignClient;
	
	
	@Override
	public String addApplicantDetailsService(LoanApplicantionCustomerIdDTO loanApplicantionCustomerIdDTO) 
	{
		LOGGER.info("ApplicantDetailsServiceImpl : PostMapping : addApplicantDetailsService : Entry");
				
		PropertyDetails propertyDetails=new PropertyDetails();
		
		LoanDetails loanDetails=new LoanDetails();
		
	    GuarantorLocalAddress guarantorLocalAddress=new GuarantorLocalAddress();
	    
	    GuarantorPermanentAddress guarantorPermanentAddress=new GuarantorPermanentAddress();
	    
		GuarantorDetails guarantorDetails=new GuarantorDetails();
								   guarantorDetails.setGuarantorLoaclAddress(guarantorLocalAddress);
								   guarantorDetails.setGuarantorPermanentAddress(guarantorPermanentAddress);
		
		IncomeDetails incomeDetails=new IncomeDetails();
		
		
		ApplicantDetails applicantDetails=new ApplicantDetails();
								  applicantDetails.setAccountStatus(AccountStatusEnum.INPROCESS);
							      applicantDetails.setPropertyId(propertyDetails);
							      applicantDetails.setLoanId(loanDetails);
								  applicantDetails.setGuarantorId(guarantorDetails);
								  applicantDetails.setIncomeId(incomeDetails);
								  applicantDetails.setCustomerId(loanApplicantionCustomerIdDTO.getCustomerId());
								  applicantDetails.setCibilScore(loanApplicantionCustomerIdDTO.getCibilScore());
				
	    applicantDetailsRepository.save(applicantDetails);
	    LOGGER.debug("ApplicantDetailsServiceImpl : PostMapping : addApplicantDetailsService : Exit");
		return "!!!...Applicant Details Saved successfully...!!!";
	}
	
	@Override
	public String updateApplicantStatus(AccountStatusDTO accountStatusDTO, Integer applicantId) 
	{
		if(applicantDetailsRepository.findById(applicantId).isPresent())
		{
			LOGGER.debug("ApplicantDetailsServiceImpl : PatchMapping : updateApplicantStatus : Entry");
			ApplicantDetails applicantDetails = applicantDetailsRepository.findById(applicantId).get();
									  applicantDetails.setAccountStatus(accountStatusDTO.getAccountStatus());
									  
			LOGGER.debug("ApplicantDetailsServiceImpl : PatchMapping : updateApplicantStatus : Exit");
			applicantDetailsRepository.save(applicantDetails);
			
			if(applicantDetails.getAccountStatus().equals(AccountStatusEnum.ACCEPTED))
			{
				if(applicantDetails.getIncomeId().getOccupation().equals(OccupationEnum.SALARIED) || applicantDetails.getIncomeId().getOccupation().equals(OccupationEnum.PENSIONER))
				{
					LoanSanctionDTO loanSanctionDTO=new LoanSanctionDTO();
										         loanSanctionDTO.setApplicantName(applicantDetails.getIncomeId().getSalariedId().getEmployeeFullName());
										         loanSanctionDTO.setAppllicantId(applicantDetails.getApplicantId());
										         loanSanctionDTO.setCibilScore(applicantDetails.getCibilScore());
										         loanSanctionDTO.setContactNo(applicantDetails.getIncomeId().getSalariedId().getContactNo());
										         loanSanctionDTO.setCustomerId(applicantDetails.getCustomerId());
										         loanSanctionDTO.setRequestedLoanAmount(applicantDetails.getLoanId().getRequestedLoanAmount());
										         loanSanctionDTO.setAccountNumber(applicantDetails.getLoanId().getAccountNumber());
										         loanSanctionDTO.setIFSC_Code(applicantDetails.getLoanId().getIFSC_Code());
										         loanSanctionDTO.setNetMonthlyIncome(applicantDetails.getIncomeId().getSalariedId().getEmployeeNetMonthlyIncome());
										         loanSanctionDTO.setLoanTenureInMonth(applicantDetails.getLoanId().getTenure());
				loanSanctionApiFeignClient.addSanctionDetails(loanSanctionDTO);
				}
				else
				{
					LoanSanctionDTO loanSanctionDTO=new LoanSanctionDTO();
												loanSanctionDTO.setApplicantName(applicantDetails.getIncomeId().getNonSalariedId().getFullname());
												loanSanctionDTO.setAppllicantId(applicantDetails.getApplicantId());
												loanSanctionDTO.setCibilScore(applicantDetails.getCibilScore());
												loanSanctionDTO.setContactNo(applicantDetails.getIncomeId().getNonSalariedId().getMobileNo());
												loanSanctionDTO.setCustomerId(applicantDetails.getCustomerId());
												loanSanctionDTO.setRequestedLoanAmount(applicantDetails.getLoanId().getRequestedLoanAmount());
										        loanSanctionDTO.setAccountNumber(applicantDetails.getLoanId().getAccountNumber());
										        loanSanctionDTO.setIFSC_Code(applicantDetails.getLoanId().getIFSC_Code());
										        loanSanctionDTO.setNetMonthlyIncome(applicantDetails.getIncomeId().getNonSalariedId().getNetMonthlyIncome());
										        loanSanctionDTO.setLoanTenureInMonth(applicantDetails.getLoanId().getTenure());
					loanSanctionApiFeignClient.addSanctionDetails(loanSanctionDTO);
												
				}
			}
			
			return "!!!...Applicant Status Updated SuccessFully...!!!";
		}
		else
		{
			LOGGER.debug("ApplicantDetailsServiceImpl : PatchMapping : updateApplicantStatus : Exit");
			throw new CustomeException("For Given Applicant Id Record Is Not Present");
		}
	}
	
	
}
