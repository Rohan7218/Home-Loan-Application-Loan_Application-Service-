package com.example.application.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PropertyDocumentDTO {
	
	private MultipartFile saleAgreement;

	private MultipartFile reraCertificate;
	
	private MultipartFile propertyTaxReceipts;
	
	private MultipartFile approvedBuildingPlan;
}
