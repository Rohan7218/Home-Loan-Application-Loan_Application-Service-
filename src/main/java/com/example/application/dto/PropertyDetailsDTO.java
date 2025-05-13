package com.example.application.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class PropertyDetailsDTO {
	
	private Long reraId;

	
	private Boolean isReraRegistered;
	
	
	private String projectName;
	
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	@Enumerated(EnumType.STRING)
	private PropertyStatus propertyStatus ;

	
	private String propertyLocation;
	
	
	private Double builtUpArea;
	
	
	private Double carpetArea;
	
	
	private Double SuperBuiltupArea;
	
	
	private String wingName;
	
	
	private Integer flatNo;
	
	
	private String areaName;
	
	
	private String cityName;
	
	
	private Integer pincode;
	
	
	private String state ;
	
	@Enumerated(EnumType.STRING)
	private OwnershipStatus ownershipStatus;

	
	private LocalDate possesionDate;
	

	private Double propertyValue;
	
	private Double downPayment;

}
