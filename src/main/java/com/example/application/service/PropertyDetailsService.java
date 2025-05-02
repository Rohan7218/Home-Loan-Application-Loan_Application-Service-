package com.example.application.service;

import java.util.List;

import com.example.application.dto.PropertyDetailsDTO;
import com.example.application.entity.PropertyDetails;

public interface PropertyDetailsService {

	String addPropertyDetails(PropertyDetailsDTO propertyDetailsDTO);

	List<PropertyDetails> getAllPropertyDetails();

	PropertyDetails getPropertyDetails(Integer customerId);

	

}
