/**
 * 
 */
package com.youplus.model;

/**
 * @author Manish
 *
 */
public class Ride {

	private long id;

	private String status;

	private long customerId;

	private long driverId;

	private long requestTime;

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
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the driverId
	 */
	public long getDriverId() {
		return driverId;
	}

	/**
	 * @param driverId
	 *            the driverId to set
	 */
	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	/**
	 * @return the requestTime
	 */
	public long getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime
	 *            the requestTime to set
	 */
	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

}
