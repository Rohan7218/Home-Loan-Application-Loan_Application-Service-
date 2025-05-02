package com.example.application.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.LoanDetailsDTO;
import com.example.application.entity.LoanDetails;
import com.example.application.repository.LoanDetailsRepository;
import com.example.application.service.LoanDetailsService;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {
	@Autowired
	private LoanDetailsRepository loanDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addLoanDetails(LoanDetailsDTO loanDetailsDTO) {

		LoanDetails loanDetails = modelMapper.map(loanDetailsDTO, LoanDetails.class);
		loanDetailsRepository.save(loanDetails);
		return "!!!...Loan Details Added Succesfully...!!!";
	}

	@Override
	public List<LoanDetails> getAllLoanDetails() {
		List<LoanDetails> loanDetailsList = loanDetailsRepository.findAll();
		return loanDetailsList;
	}
}
