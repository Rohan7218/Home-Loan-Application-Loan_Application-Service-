package com.example.application.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.GuarantorDetailsDTO;
import com.example.application.dto.UpdateGuarantorDetailsDTO;
import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.GuarantorDetails;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.repository.GuarantorDetailsRespotory;
import com.example.application.service.GuarantorDetailsService;

@Service
public class GuarantorDetailsServiceImpl implements GuarantorDetailsService
{
	@Autowired
	private GuarantorDetailsRespotory guarantorDetailsRespotory;
	
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GuarantorDetailsServiceImpl.class);

	@Override
	public String addGuarantorDetails(GuarantorDetailsDTO guarantorDetailsDTO, Integer guarantorId)
	{
		if(guarantorDetailsRespotory.findById(guarantorId).isPresent())
		{
			GuarantorDetails existedGuarantorDetails = guarantorDetailsRespotory.findById(guarantorId).get();
					
			LOGGER.debug("GuarantorDetailsServiceImpl : addGuarantorDetails : Entry");
			 GuarantorDetails guarantorDetails = modelMapper.map(guarantorDetailsDTO,GuarantorDetails.class);
			 							guarantorDetails.setGuarantorDetailsID(guarantorId);
			 							guarantorDetails.setGuarantorLoaclAddress(existedGuarantorDetails.getGuarantorLoaclAddress());
			 							guarantorDetails.setGuarantorPermanentAddress(existedGuarantorDetails.getGuarantorPermanentAddress());
			 guarantorDetailsRespotory.save(guarantorDetails);
			LOGGER.debug("GuarantorDetailsServiceImpl : addGuarantorDetails : Exit");
			return "!!..GuarantorDetails Added Succesfully ..!!";
		}
		return null;
		
	}
	
	
	@Override
	public GuarantorDetails getGuarantorDetails(Integer applicantId) {
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findById(applicantId);
		if(optional.isPresent())
		{
			LOGGER.debug("GuarantorDetailsServiceImpl : getGuarantorDetails : Entry");
			GuarantorDetails guarantorDetails = optional.get().getGuarantorId();
			LOGGER.debug("GuarantorDetailsServiceImpl : getGuarantorDetails : Exit");
			return guarantorDetails;
		}
		return null;
	}
	
	@Override
	public String updateGuarantorDetails(Integer applicantId, UpdateGuarantorDetailsDTO updateGuarantorDetailsDTO) {
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findById(applicantId);
		if(optional.isPresent())
		{
			LOGGER.debug("GuarantorDetailsServiceImpl : getGuarantorDetails : Entry");
			GuarantorDetails guarantorDetails = optional.get().getGuarantorId();
			if(updateGuarantorDetailsDTO.getGuarantorFirstName()!=null)
			{
				guarantorDetails.setGuarantorFirstName(updateGuarantorDetailsDTO.getGuarantorFirstName());
			}
			if(updateGuarantorDetailsDTO.getGuarantorMiddleName()!=null)
			{
				guarantorDetails.setGuarantorMiddleName(updateGuarantorDetailsDTO.getGuarantorMiddleName());
			}
			if(updateGuarantorDetailsDTO.getGuarantorLastName()!=null)
			{
				guarantorDetails.setGuarantorLastName(updateGuarantorDetailsDTO.getGuarantorLastName());
			}
			if(updateGuarantorDetailsDTO.getGuarantorDateOfBirth()!=null)
			{
				guarantorDetails.setGuarantorDateOfBirth(updateGuarantorDetailsDTO.getGuarantorDateOfBirth());
			}
			if(updateGuarantorDetailsDTO.getGuarantorRelationshipwithCustomer()!=null)
			{
				guarantorDetails.setGuarantorRelationshipwithCustomer(updateGuarantorDetailsDTO.getGuarantorRelationshipwithCustomer());
			}
			if(updateGuarantorDetailsDTO.getGuarantorMobileNumber()!=null)
			{
				guarantorDetails.setGuarantorMobileNumber(updateGuarantorDetailsDTO.getGuarantorMobileNumber());
			}
			if(updateGuarantorDetailsDTO.getGuarantorMortgageDetails()!=null)
			{
				guarantorDetails.setGuarantorMortgageDetails(updateGuarantorDetailsDTO.getGuarantorMortgageDetails());
			}
			if(updateGuarantorDetailsDTO.getGuarantorJobDetails()!=null)
			{
				guarantorDetails.setGuarantorJobDetails(updateGuarantorDetailsDTO.getGuarantorJobDetails());
			}
			
			guarantorDetailsRespotory.save(guarantorDetails);
			LOGGER.debug("GuarantorDetailsServiceImpl : getGuarantorDetails : Exit");
			return "!!..Guarantor Details Updated Succesfully ";
		}
		return "!!..Record Not Found For that Applicant Id :"+" "+applicantId;
	}
	
}
