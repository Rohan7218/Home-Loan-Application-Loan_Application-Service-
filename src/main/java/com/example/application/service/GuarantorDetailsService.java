package com.example.application.service;

import com.example.application.dto.GuarantorDetailsDTO;
import com.example.application.dto.UpdateGuarantorDetailsDTO;
import com.example.application.entity.GuarantorDetails;

public interface GuarantorDetailsService {

	String addGuarantorDetails(GuarantorDetailsDTO guarantorDetailsDTO, Integer guarantorId);

	GuarantorDetails getGuarantorDetails(Integer applicantId);

	String updateGuarantorDetails(Integer applicantId, UpdateGuarantorDetailsDTO updateGuarantorDetailsDTO);

	


}
