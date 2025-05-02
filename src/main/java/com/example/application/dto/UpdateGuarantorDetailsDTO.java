package com.example.application.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateGuarantorDetailsDTO {

	private String guarantorFirstName;

	private String guarantorMiddleName;

	private String guarantorLastName;

	private LocalDate guarantorDateOfBirth;

	private String guarantorRelationshipwithCustomer;

	private Long guarantorMobileNumber;

	private String guarantorMortgageDetails;

	private String guarantorJobDetails;
}
