package com.example.application.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.GuarantorDetails;
import com.example.application.entity.GuarantorLocalAddress;
import com.example.application.entity.GuarantorPermanentAddress;
import com.example.application.entity.IncomeDetails;
import com.example.application.entity.LoanDetails;
import com.example.application.entity.PropertyDetails;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.service.ApplicantDetailsService;

@Service
public class ApplicantDetailsServiceImpl implements ApplicantDetailsService
{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ApplicantDetailsServiceImpl.class);
	
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;
	
	@Override
	public String addApplicantDetailsService() 
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
							      applicantDetails.setPropertyId(propertyDetails);
							      applicantDetails.setLoanId(loanDetails);
								  applicantDetails.setGuarantorId(guarantorDetails);
								  applicantDetails.setIncomeId(incomeDetails);
								  
								  								  

	    applicantDetailsRepository.save(applicantDetails);
	    LOGGER.debug("ApplicantDetailsServiceImpl : PostMapping : addApplicantDetailsService : Exit");
		return "!!!...Applicant Details Saved successfully...!!!";
	}
}
