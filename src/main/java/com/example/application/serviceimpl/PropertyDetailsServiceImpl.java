package com.example.application.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.repository.PropertyDetailsRepository;
import com.example.application.service.PropertyDetailsService;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService
{
	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;
}
