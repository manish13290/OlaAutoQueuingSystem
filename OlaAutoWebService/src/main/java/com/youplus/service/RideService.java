/**
 * 
 */
package com.youplus.service;

import java.util.List;

import com.youplus.model.Driver;
import com.youplus.model.Ride;

/**
 * @author Manish
 *
 */
public interface RideService {

	Boolean createRideRequest(String customerId);

	Boolean acceptRideRequest(long rideId, long driverId);

	List<Ride> getALlRideRequest();

	Driver getDriver(long driverId);
}
