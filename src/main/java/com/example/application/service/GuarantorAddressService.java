package com.example.application.service;

import com.example.application.dto.GuarantorAddressDTO;
import com.example.application.dto.UpdateGuarantorAddressDTO;

public interface GuarantorAddressService {

	String addGuarantorAddress(GuarantorAddressDTO guarantorAddressDTO);

	String updateGuarantorLocalAddress(Integer applicantId, UpdateGuarantorAddressDTO updateGuarantorAddressDTO);

}
