package com.example.application.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.EmployeeDetails;
import com.example.application.entity.GuarantorDetails;
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
		EmployeeDetails empployeeDetails=new EmployeeDetails();
		
		PropertyDetails propertyDetails=new PropertyDetails();
		
		LoanDetails loanDetails=new LoanDetails();
		
		GuarantorDetails guarantorDetails=new GuarantorDetails();
		
		ApplicantDetails applicantDetails=new ApplicantDetails();
								  applicantDetails.setEmployeeId(empployeeDetails);
								  applicantDetails.setGuarantorId(guarantorDetails);
								  applicantDetails.setLoanId(loanDetails);
								  applicantDetails.setPropertyId(propertyDetails);

	    applicantDetailsRepository.save(applicantDetails);
	    LOGGER.debug("ApplicantDetailsServiceImpl : PostMapping : addApplicantDetailsService : Exit");
		return "!!!...Applicant Details Saved successfully...!!!";
	}
}
