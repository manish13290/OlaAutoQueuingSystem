/**
 * 
 */
package com.youplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youplus.constant.RestURLConstants;
import com.youplus.model.Driver;
import com.youplus.model.JSONResponse;
import com.youplus.service.RideService;

/**
 * @author Manish
 *
 */
@RestController
@RequestMapping(value = RestURLConstants.DRIVER)
public class DriverController {

	@Autowired
	private RideService service;

	@RequestMapping(value = RestURLConstants.ID_PARAM, method = RequestMethod.GET)
	public JSONResponse getDriverById(@PathVariable("id") Long id) {
		System.out.println("in rest");
		Driver d = service.getDriver(id);
		JSONResponse response = new JSONResponse();
		if (d == null) {
			response.setAnyError(true);
			response.setErrorReason("We couldn't find driver with this id : " + id);
		} else {
			response.setAnyError(false);
			response.getDataList().add(d);
		}

		return response;
	}

}
