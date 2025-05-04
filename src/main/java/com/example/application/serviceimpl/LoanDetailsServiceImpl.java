package com.example.application.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;
import com.example.application.exceptionhandling.CustomeException;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.repository.LoanDetailsRepository;
import com.example.application.rest.LoanDetailsController;
import com.example.application.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanDetailsController.class);

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addLoanDetails(LoanDetailsDTO loanDetailsDTO, Integer loanDetailsID) 
	{
		if (loanDetailsRepository.findById(loanDetailsID).isPresent()) 
		{
			LOGGER.debug("LoanDetailsServiceImpl : addLoanInfo : Entry");

			LoanDetails loanDetails = modelMapper.map(loanDetailsDTO, LoanDetails.class);
							   loanDetails.setLoanDetailsID(loanDetailsID);
			
			loanDetailsRepository.save(loanDetails);
			LOGGER.debug("LoanDetailsServiceImpl : addLoanInfo : Exit");
			return "!!!...Loan Details Added Succesfully...!!!";
		}
		else
		{
			LOGGER.debug("LoanDetailsServiceImpl : addLoanInfo : Exit");
			throw new CustomeException("!!!...Invalid Load Details ID...!!!");
		}
	}

	@Override
	public List<LoanDetails> getAllLoanDetails() {
		LOGGER.debug("LoanDetailsServiceImpl : getAllLoanDetails : Entry");
		List<LoanDetails> loanDetailsList = loanDetailsRepository.findAll();
		if(!loanDetailsList.isEmpty())
		{
			LOGGER.debug("LoanDetailsServiceImpl : getAllLoanDetails : Exit");
			return loanDetailsList;
		}
		else
		{
			LOGGER.debug("LoanDetailsServiceImpl : getAllLoanDetails : Exit");
			throw new CustomeException("!!!...Loan Details Records Are Not Available...!!!");
		}
	}

	@Override
	public LoanDetails getLoanDetail(Integer applicantId)
	{
		LOGGER.debug("LoanDetailsServiceImpl : getLoanDetails : Entry");
		if (applicantDetailsRepository.findById(applicantId).isPresent()) 
		{
			LoanDetails loanDetails = applicantDetailsRepository.findById(applicantId).get().getLoanId();
			LOGGER.debug("LoanDetailsServiceImpl : getAllLoanDetails : Exit");
			return loanDetails;
		}
		else
		{
			LOGGER.debug("LoanDetailsServiceImpl : getAllLoanDetails : Exit");
			throw new CustomeException("!!!...For Given Applicant Id Loan Details Record Is Not Availablea...!!!");
		}
		
		
	}

	@Override
	public String updateLoanDetails(LoanDetailsDTO loanDetailsDTO, Integer applicantId) {

		if (applicantDetailsRepository.existsById(applicantId)) 
		{
			LOGGER.debug("LoanDetailsServiceImpl : updateLoanDetails : Entry");
			LoanDetails existingLoanDetails = applicantDetailsRepository.findById(applicantId).get().getLoanId();

			if (loanDetailsDTO.getAccountHolderName() != null) {
				existingLoanDetails.setAccountHolderName(loanDetailsDTO.getAccountHolderName());
			}

			if (loanDetailsDTO.getAccountNumber() != null) {
				existingLoanDetails.setAccountNumber(loanDetailsDTO.getAccountNumber());
			}

			if (loanDetailsDTO.getAccountType() != null) {
				existingLoanDetails.setAccountType(loanDetailsDTO.getAccountType());
			}

			if (loanDetailsDTO.getBankName() != null) {
				existingLoanDetails.setBankName(loanDetailsDTO.getBankName());
			}

			if (loanDetailsDTO.getBranchName() != null) {
				existingLoanDetails.setBranchName(loanDetailsDTO.getBranchName());
			}

			if (loanDetailsDTO.getIFSC_Code() != null) {
				existingLoanDetails.setIFSC_Code(loanDetailsDTO.getIFSC_Code());
			}

			if (loanDetailsDTO.getLoanPurpose() != null) {
				existingLoanDetails.setLoanPurpose(loanDetailsDTO.getLoanPurpose());
			}

			if (loanDetailsDTO.getMoratorium() != null) {
				existingLoanDetails.setMoratorium(loanDetailsDTO.getMoratorium());
			}

			if (loanDetailsDTO.getRequestedLoanAmount() != null) {
				existingLoanDetails.setRequestedLoanAmount(loanDetailsDTO.getRequestedLoanAmount());
			}

			if (loanDetailsDTO.getTenure() != null) {
				existingLoanDetails.setTenure(loanDetailsDTO.getTenure());
			}

			loanDetailsRepository.save(existingLoanDetails);
			LOGGER.debug("LoanDetailsServiceImpl : updateLoanDetails : Exit");
			return "!!!...Loan Details Updated Successfully...!!!";
		}
		else
		{
			LOGGER.debug("LoanDetailsServiceImpl : updateLoanDetails : Exit");
			throw new CustomeException("!!!...For Given Applicant Id Loan Details Record Is Not Availablea...!!!");
		}
	}
}
