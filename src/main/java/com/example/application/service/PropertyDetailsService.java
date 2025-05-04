package com.example.application.service;

import java.util.List;

import com.example.application.dto.PropertyDetailsDTO;
import com.example.application.dto.PropertyDocumentDTO;
import com.example.application.dto.UpdatePropertyDetailsDTO;
import com.example.application.entity.PropertyDetails;

public interface PropertyDetailsService {

	String addPropertyDetails(PropertyDetailsDTO propertyDetailsDTO, Integer propertyDetailsID);

	List<PropertyDetails> getAllPropertyDetails();

	PropertyDetails getPropertyDetails(Integer customerId);

	String updatePropertyDetails(Integer applicantId, UpdatePropertyDetailsDTO updatePropertyDetailsDTO);

	String uploadPropertyDocuments(Integer applicantId, PropertyDocumentDTO propertyDocumentDTO);

	

}
