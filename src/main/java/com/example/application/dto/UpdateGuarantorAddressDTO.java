package com.example.application.dto;

import lombok.Data;

@Data
public class UpdateGuarantorAddressDTO {
	
	
	private String localAreaname;

	private String localCityname;

	private String localDistrict;

	private String localState;

	private Integer localPincode;

	private Integer localHouseNumber;

	private String localStreetName;

}
