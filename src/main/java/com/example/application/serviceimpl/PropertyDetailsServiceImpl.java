package com.example.application.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.PropertyDetailsDTO;
import com.example.application.dto.PropertyDocumentDTO;
import com.example.application.dto.UpdatePropertyDetailsDTO;
import com.example.application.entity.ApplicantDetails;
import com.example.application.entity.PropertyDetails;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.repository.PropertyDetailsRepository;
import com.example.application.rest.PropertyDetailsController;
import com.example.application.service.PropertyDetailsService;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {
	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;

	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyDetailsController.class);

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
	public PropertyDetails getPropertyDetails(Integer applicantId) {

		LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Entry");
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findById(applicantId);
		if (optional.isPresent()) {
			PropertyDetails propertyDetails = optional.get().getPropertyId();
			LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Exit");
			return propertyDetails;
		}
		LOGGER.debug("PropertyDetailsServiceImpl : getPropertyDetails : Exit");
		return null;
	}

	@Override
	public String updatePropertyDetails(Integer applicantId, UpdatePropertyDetailsDTO updatePropertyDetailsDTO) {
		if (applicantDetailsRepository.existsById(applicantId)) {
			LOGGER.debug("PropertyDetailsServiceImpl : updatePropertyDetails : Entry");
			PropertyDetails propertyDetails = applicantDetailsRepository.findById(applicantId).get().getPropertyId();
			if (updatePropertyDetailsDTO.getReraId() != null) {
				propertyDetails.setReraId(updatePropertyDetailsDTO.getReraId());
			}
			if (updatePropertyDetailsDTO.getIsReraRegistered() != null) {
				propertyDetails.setIsReraRegistered(updatePropertyDetailsDTO.getIsReraRegistered());
			}
			if (updatePropertyDetailsDTO.getProjectName() != null) {
				propertyDetails.setProjectName(updatePropertyDetailsDTO.getProjectName());
			}
			if (updatePropertyDetailsDTO.getPropertyType() != null) {
				propertyDetails.setPropertyType(updatePropertyDetailsDTO.getPropertyType());
			}
			if (updatePropertyDetailsDTO.getPropertyStatus() != null) {
				propertyDetails.setPropertyStatus(updatePropertyDetailsDTO.getPropertyStatus());
			}
			if (updatePropertyDetailsDTO.getPropertyLocation() != null) {
				propertyDetails.setPropertyLocation(updatePropertyDetailsDTO.getPropertyLocation());
			}
			if (updatePropertyDetailsDTO.getBuiltUpArea() != null) {
				propertyDetails.setBuiltUpArea(updatePropertyDetailsDTO.getBuiltUpArea());
			}
			if (updatePropertyDetailsDTO.getCarpetArea() != null) {
				propertyDetails.setCarpetArea(updatePropertyDetailsDTO.getCarpetArea());
			}
			if (updatePropertyDetailsDTO.getSuperBuiltupArea() != null) {
				propertyDetails.setSuperBuiltupArea(updatePropertyDetailsDTO.getSuperBuiltupArea());
			}
			if (updatePropertyDetailsDTO.getWingName() != null) {
				propertyDetails.setWingName(updatePropertyDetailsDTO.getWingName());
			}
			if (updatePropertyDetailsDTO.getFlatNo() != null) {
				propertyDetails.setFlatNo(updatePropertyDetailsDTO.getFlatNo());
			}
			if (updatePropertyDetailsDTO.getAreaName() != null) {
				propertyDetails.setAreaName(updatePropertyDetailsDTO.getAreaName());
			}
			if (updatePropertyDetailsDTO.getCityName() != null) {
				propertyDetails.setCityName(updatePropertyDetailsDTO.getCityName());
			}
			if (updatePropertyDetailsDTO.getPincode() != null) {
				propertyDetails.setPincode(updatePropertyDetailsDTO.getPincode());
			}
			if (updatePropertyDetailsDTO.getState() != null) {
				propertyDetails.setState(updatePropertyDetailsDTO.getState());
			}
			if (updatePropertyDetailsDTO.getOwnershipStatus() != null) {
				propertyDetails.setOwnershipStatus(updatePropertyDetailsDTO.getOwnershipStatus());
			}
			if (updatePropertyDetailsDTO.getPossesionDate() != null) {
				propertyDetails.setPossesionDate(updatePropertyDetailsDTO.getPossesionDate());
			}
			if (updatePropertyDetailsDTO.getPropertyValue() != null) {
				propertyDetails.setPropertyValue(updatePropertyDetailsDTO.getPropertyValue());
			}

			propertyDetailsRepository.save(propertyDetails);
			LOGGER.debug("PropertyDetailsServiceImpl : updatePropertyDetails : Exit");
			return "!!..Property Details Updated Succesfully ...!!";
		}
		LOGGER.debug("PropertyDetailsServiceImpl : updatePropertyDetails : Exit");
		return "!!..Applicant Id Not Found ...!!";
	}

	@Override
	public String uploadPropertyDocuments(Integer applicantId, PropertyDocumentDTO propertyDocumentDTO) {
		Optional<ApplicantDetails> optional = applicantDetailsRepository.findById(applicantId);
		if (optional.isPresent()) {
			LOGGER.debug("PropertyDetailsServiceImpl : uploadPropertyDocuments : Entry");
			PropertyDetails propertyDetails = modelMapper.map(propertyDocumentDTO, PropertyDetails.class);
			propertyDetailsRepository.save(propertyDetails);
			LOGGER.debug("PropertyDetailsServiceImpl : uploadPropertyDocuments : Exit");
			return "Property Details Document upload succesfully";
		}
		LOGGER.debug("PropertyDetailsServiceImpl : uploadPropertyDocuments : Exit");
		return "Applicant Id Not Found";
	}

}
