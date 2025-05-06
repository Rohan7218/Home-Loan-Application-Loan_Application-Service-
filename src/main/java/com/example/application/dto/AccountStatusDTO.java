package com.example.application.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class AccountStatusDTO {

	@Enumerated(EnumType.STRING)
	private AccountStatusEnum accountStatus;
	
}
