/**
 * 
 */
package com.youplus.dao;

import com.youplus.entity.CustomerEntity;
import com.youplus.entity.DriverEntity;
import com.youplus.entity.RideEntity;

/**
 * @author Manish
 *
 */
public interface RideRequestDao extends GenericDao<RideEntity, Long> {

	void createRideRequest(CustomerEntity customer);

	void confirmRideRequest(long rideId, DriverEntity driver);

	void finishRide(long rideId);

}
