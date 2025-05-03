package com.example.application.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.dto.GuarantorAddressDTO;
import com.example.application.dto.UpdateGuarantorAddressDTO;
import com.example.application.entity.GuarantorLoaclAddress;
import com.example.application.entity.GuarantorPermanentAddress;
import com.example.application.repository.ApplicantDetailsRepository;
import com.example.application.repository.GuarantorLoaclAddressRepository;
import com.example.application.repository.GuarantorPermanentAddressRepositoy;
import com.example.application.service.GuarantorAddressService;

@Service
public class GuarantorAddressServiceImpl implements GuarantorAddressService {

	@Autowired
	private GuarantorLoaclAddressRepository guarantorLoaclAddressRepository;

	@Autowired
	private GuarantorPermanentAddressRepositoy guarantorPermanentAddressRepositoy;

	@Autowired
	private ApplicantDetailsRepository applicantDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	private static final Logger LOGGER = LoggerFactory.getLogger(GuarantorAddressServiceImpl.class);

	@Override
	public String addGuarantorAddress(GuarantorAddressDTO guarantorAddressDTO) {
		LOGGER.debug("GuarantorAddressServiceImpl : addGuarantorAddress : Entry");

		GuarantorLoaclAddress localAddress = modelMapper.map(guarantorAddressDTO, GuarantorLoaclAddress.class);
		GuarantorPermanentAddress permanentAddress = modelMapper.map(guarantorAddressDTO,
				GuarantorPermanentAddress.class);

		guarantorLoaclAddressRepository.save(localAddress);
		guarantorPermanentAddressRepositoy.save(permanentAddress);
		LOGGER.debug("GuarantorAddressServiceImpl : addGuarantorAddress : Exit");
		return "!!..Guarantor Local And Permanent Address Add Succesfully ..!!";
	}

	@Override
	public String updateGuarantorLocalAddress(Integer applicantId,
			UpdateGuarantorAddressDTO updateGuarantorAddressDTO) {
		if (applicantDetailsRepository.existsById(applicantId))
		{
			LOGGER.debug("GuarantorAddressServiceImpl : updateGuarantorLocalAddress : Entry");
			GuarantorLoaclAddress guarantorLoaclAddress = applicantDetailsRepository.findById(applicantId).get().getGuarantorId().getGuarantorLoaclAddress();
			if(updateGuarantorAddressDTO.getLocalHouseNumber()!=null)
			{
				guarantorLoaclAddress.setLocalHouseNumber(updateGuarantorAddressDTO.getLocalHouseNumber());
			}
			
			if(updateGuarantorAddressDTO.getLocalAreaname()!=null)
			{
				guarantorLoaclAddress.setLocalAreaname(updateGuarantorAddressDTO.getLocalAreaname());
			}
			
			if(updateGuarantorAddressDTO.getLocalCityname()!=null)
			{
				guarantorLoaclAddress.setLocalCityname(updateGuarantorAddressDTO.getLocalCityname());
			}
			
			if(updateGuarantorAddressDTO.getLocalDistrict()!=null)
			{
				guarantorLoaclAddress.setLocalDistrict(updateGuarantorAddressDTO.getLocalDistrict());
			}
			
			if(updateGuarantorAddressDTO.getLocalState()!=null)
			{
				guarantorLoaclAddress.setLocalState(updateGuarantorAddressDTO.getLocalState());
			}
			
			if(updateGuarantorAddressDTO.getLocalPincode()!=null)
			{
				guarantorLoaclAddress.setLocalPincode(updateGuarantorAddressDTO.getLocalPincode());
			}
			
			if(updateGuarantorAddressDTO.getLocalStreetName()!=null)
			{
				guarantorLoaclAddress.setLocalStreetName(updateGuarantorAddressDTO.getLocalStreetName());
			}
			guarantorLoaclAddressRepository.save(guarantorLoaclAddress);
			LOGGER.debug("GuarantorAddressServiceImpl : updateGuarantorLocalAddress : Exit");
			return "!!..Guarantor Local Address Updated Succesfully";
		}
		return "!!..Record Not Found For that Applicant Id :"+" "+applicantId;
	}

}
