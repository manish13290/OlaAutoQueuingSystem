package com.youplus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youplus.dao.CustomerDao;
import com.youplus.dao.DriverDao;
import com.youplus.dao.RideRequestDao;
import com.youplus.entity.CustomerEntity;
import com.youplus.entity.DriverEntity;
import com.youplus.entity.RideEntity;
import com.youplus.model.Driver;
import com.youplus.model.Ride;

@Service
@Transactional
public class RideServiceImpl implements RideService {

	@Autowired
	private RideRequestDao rideDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private DriverDao driverDao;

	@Override
	public Boolean createRideRequest(String customerId) {
		// create customer first;
		CustomerEntity customer = customerDao.findCustomerByCustomerId(customerId);
		if (customer == null) {
			customer = new CustomerEntity();
			customer.setCustomerId(customerId);
			customerDao.add(customer);
		}
		rideDao.createRideRequest(customer);
		return true;
	}

	@Override
	public Boolean acceptRideRequest(long rideId, long driverId) {
		DriverEntity driver = driverDao.find(driverId);
		if (driver != null) {
			rideDao.confirmRideRequest(rideId, driver);
		}
		return true;
	}

	@Override
	public List<Ride> getALlRideRequest() {
		List<Ride> rideRequestList = new ArrayList<Ride>();
		List<RideEntity> rideList = rideDao.getAll();
		for (RideEntity rideE : rideList) {
			Ride ride = new Ride();
			DriverEntity d = rideE.getDriver();
			if (d != null) {
				ride.setDriverId(d.getId());
			}
			rideRequestList.add(ride);
		}
		return rideRequestList;
	}

	@Override
	public Driver getDriver(long driverId) {
		DriverEntity driverE = driverDao.find(driverId);
		Driver driver = null;
		if (driverE != null) {
			driver = new Driver();
			driver.setId(driverE.getId());
		}
		return driver;
	}

}
