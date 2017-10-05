/**
 * 
 */
package com.youplus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.youplus.constant.RideStatus;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "rides")
public class RideEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * id field for primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private RideStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "request_time")
	public java.util.Date requestTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pickup_time")
	public java.util.Date pickupTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "finish_time")
	public java.util.Date finishTime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id", nullable = true)
	private DriverEntity driver;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	/**
	 * @return the driver
	 */
	public DriverEntity getDriver() {
		return driver;
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(DriverEntity driver) {
		this.driver = driver;
	}

	/**
	 * @return the customer
	 */
	public CustomerEntity getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public RideStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(RideStatus status) {
		this.status = status;
	}

	/**
	 * @return the requestTime
	 */
	public java.util.Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime
	 *            the requestTime to set
	 */
	public void setRequestTime(java.util.Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the pickupTime
	 */
	public java.util.Date getPickupTime() {
		return pickupTime;
	}

	/**
	 * @param pickupTime
	 *            the pickupTime to set
	 */
	public void setPickupTime(java.util.Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	/**
	 * @return the finishTime
	 */
	public java.util.Date getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime
	 *            the finishTime to set
	 */
	public void setFinishTime(java.util.Date finishTime) {
		this.finishTime = finishTime;
	}

}
