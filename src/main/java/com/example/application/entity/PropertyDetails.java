package com.example.application.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.example.application.dto.OwnershipStatus;
import com.example.application.dto.PropertyStatus;
import com.example.application.dto.PropertyType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Property_Details")
public class PropertyDetails {

	
	@SequenceGenerator(name = "propertyDetails_ID", sequenceName = "propertyDetails_ID", allocationSize = 1, initialValue =101)
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "propertyDetails_ID")
	@Column(name = "Property_Details_ID")
	@Id
	private Integer propertyDetailsID;
	
	@Column(name = "Rera_ID")
	private Long reraId;

	@Column(name = "Rera_Registered")
	private Boolean isReraRegistered;
	
	@Column(name = "Project_Name")
	private String projectName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Property_Type")
	private PropertyType propertyType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Property_Status")
	private PropertyStatus propertyStatus ;

	@Column(name = "Property_Location")
	private String propertyLocation;
	
	@Column(name = "Built_Up_Area")
	private Double builtUpArea;
	
	@Column(name = "Carpet_Area")
	private Double carpetArea;
	
	@Column(name = "Super_BuiltUp_Area")
	private Double superBuiltupArea;
	
	@Column(name = "Wing_Name")
	private String wingName;
	
	@Column(name = "Flat_No")
	private Integer flatNo;
	
	@Column(name = "Area_Name")
	private String areaName;
	
	@Column(name = "City_Name")
	private String cityName;
	
	@Column(name = "Pincode")
	private Integer pincode;
	
	@Column(name = "State")
	private String state ;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Ownership_Status")
	private OwnershipStatus ownershipStatus;

	@Column(name = "Possesion_Date")
	private LocalDate possesionDate;
	
	//private Integer propertyAge;
	@Column(name = "Property_Market_Value")
	private Double propertyValue;
	
//	private Double saleAggreementValue;
	
	@Lob
	private byte[] saleAgreement;

	
	@Lob
	private byte[] reraCertificate;

	@Lob
	private byte[] propertyTaxReceipts;
	
	@Lob
	private byte[] approvedBuildingPlan;
	
	
}
