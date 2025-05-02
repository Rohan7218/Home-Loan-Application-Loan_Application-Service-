package com.example.application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.PropertyDetailsDTO;
import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.PropertyDetails;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.repository.PropertyDetailsRepository;
import com.example.application.rest.PropertyDetailsController;
import com.example.application.service.PropertyDetailsService;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService
{
	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;
	
	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PropertyDetailsController.class);

	
	
	@Override
	public String addPropertyDetails(PropertyDetailsDTO propertyDetailsDTO) {

		LOGGER.debug("PropertyDetailsServiceImpl : addDependentInfo : Entry");
		PropertyDetails propertyDetails = modelMapper.map(propertyDetailsDTO, PropertyDetails.class);
		propertyDetailsRepository.save(propertyDetails);
		LOGGER.debug("PropertyDetailsServiceImpl : addDependentInfo : Exit");
		return "PropertyDetails Added Succesfully";
	}
	
	
	@Override
	public List<PropertyDetails> getAllPropertyDetails() {
		LOGGER.debug("PropertyDetailsServiceImpl : getAllPropertyDetails : Entry");
		List<PropertyDetails> list = propertyDetailsRepository.findAll();
		LOGGER.debug("PropertyDetailsServiceImpl : getAllPropertyDetails : Exit");
		return list;
	}
	

	@Override
	public PropertyDetails getPropertyDetails(Integer customerId) {
		
		LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Entry");
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findById(customerId);
		if(optional.isPresent())
		{
			PropertyDetails propertyDetails = optional.get().getPropertyId();
			LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Exit");
			return propertyDetails;
		}
		LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Exit");
		return null;
	}
	
}
