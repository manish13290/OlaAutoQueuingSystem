/**
 * 
 */
package com.youplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youplus.constant.RestURLConstants;
import com.youplus.model.Customer;
import com.youplus.model.JSONResponse;
import com.youplus.model.Ride;
import com.youplus.service.RideService;

/**
 * @author Manish
 *
 */
@RestController
@RequestMapping(value = RestURLConstants.RIDE)
public class RideController {

	@Autowired
	private RideService rideService;

	@RequestMapping(value = RestURLConstants.ALL_PARAM, method = RequestMethod.GET)
	public JSONResponse getALLRide() {
		List<Ride> rideList = rideService.getALlRideRequest();
		JSONResponse response = new JSONResponse();
		response.setAnyError(false);
		System.out.println(rideList);
		response.getDataList().addAll(rideList);
		return response;
	}

	@RequestMapping(value = RestURLConstants.CREATE_PARAM, method = RequestMethod.POST)
	public JSONResponse addRideRequest(@RequestBody Customer customer) {
		Boolean isRequestCreated = rideService.createRideRequest(customer.getCustomerId());
		JSONResponse response = new JSONResponse();
		response.setAnyError(!isRequestCreated);
		return response;
	}

	@RequestMapping(value = RestURLConstants.APPROVE_RIDE_REQUEST_PARAM, method = RequestMethod.GET)
	public JSONResponse acceptRideRequest(@PathVariable("id") Long rideId, @PathVariable("driverId") Long driverId) {
		Boolean isRequestCreated = rideService.acceptRideRequest(rideId, driverId);
		JSONResponse response = new JSONResponse();
		response.setAnyError(!isRequestCreated);
		return response;
	}
}
