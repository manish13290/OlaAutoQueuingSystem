package com.youplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youplus.constant.RestURLConstants;
import com.youplus.service.RideService;

@RestController
@RequestMapping(value = RestURLConstants.CUSTOMER)
public class CustomerController {

	@Autowired
	private RideService rideService;
}
