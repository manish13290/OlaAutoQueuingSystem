/**
 * 
 */
package com.youplus.model;

import java.io.Serializable;

/**
 * @author Manish
 *
 */
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String customerId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
