package com.example.application.dto;

import lombok.Data;

@Data
public class GuarantorAddressDTO {

	
	private String localAreaname;

	private String localCityname;

	private String localDistrict;

	private String localState;

	private Integer localPincode;

	private Integer localHouseNumber;

	private String localStreetName;
	
	
	
	private String permanentAreaname;

	private String permanentCityname;

	private String permanentDistrict;

	private String permanentState;

	private Integer permanentPincode;

	private Integer permanentHouseNumber;

	
	private String permanentStreetName;
}
