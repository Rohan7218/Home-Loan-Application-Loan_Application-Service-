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
	
	private String propertyType;
	
	@Enumerated(EnumType.STRING)
	
	private String propertyStatus ;

	
	private String propertyLocation;
	
	
	private Double builtUpAreaq;
	
	
	private Double carpetArea;
	
	
	private Double SuperBuiltupArea;
	
	
	private String wingName;
	
	
	private Integer flatNo;
	
	
	private String areaName;
	
	
	private String cityName;
	
	
	private Integer pincode;
	
	
	private String state ;
	
	@Enumerated(EnumType.STRING)
	private String ownershipStatus;

	
	private LocalDate possesionDate;
	

	private Double propertyValue;

}
