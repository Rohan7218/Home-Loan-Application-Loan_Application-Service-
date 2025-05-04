package com.example.application.service;

import com.example.application.dto.IncomeDetailsDTO;
import com.example.application.entity.IncomeDetails;

public interface IncomeDetailsService {

	String addIncomeDetails(IncomeDetailsDTO incomeDetailsDTO, Integer incomeId);

	String updateIncomeDetails(IncomeDetailsDTO incomeDetailsDTO, Integer incomeId);

	IncomeDetails getIncomeDetails(Integer incomeId);

	

}
