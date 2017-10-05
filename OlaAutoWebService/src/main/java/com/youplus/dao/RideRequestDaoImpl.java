package com.youplus.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.youplus.constant.RideStatus;
import com.youplus.entity.CustomerEntity;
import com.youplus.entity.DriverEntity;
import com.youplus.entity.RideEntity;

@Repository
@Transactional
public class RideRequestDaoImpl extends GenericDaoImpl<RideEntity, Long>implements RideRequestDao {

	public RideRequestDaoImpl() {
	}

	@Override
	public void createRideRequest(CustomerEntity customer) {
		RideEntity ride = new RideEntity();
		ride.setRequestTime(new Date());
		ride.setCustomer(customer);
		ride.setStatus(RideStatus.WAITING);
		add(ride);
	}

	@Override
	public void confirmRideRequest(long rideId, DriverEntity driver) {
		RideEntity ride = find(rideId);
		ride.setDriver(driver);
		ride.setStatus(RideStatus.ONGOING);
		ride.setPickupTime(new Date());
		update(ride);
	}

	@Override
	public void finishRide(long rideId) {
		RideEntity ride = find(rideId);
		ride.setFinishTime(new Date());
		update(ride);
	}

}
