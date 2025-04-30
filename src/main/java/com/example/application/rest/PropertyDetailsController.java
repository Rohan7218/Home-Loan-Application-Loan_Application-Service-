package com.example.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.service.PropertyDetailsService;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyDetailsController 
{
	@Autowired
	private PropertyDetailsService propertyDetailsService;
}
