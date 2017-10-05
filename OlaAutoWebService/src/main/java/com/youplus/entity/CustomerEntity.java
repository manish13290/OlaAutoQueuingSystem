/**
 * 
 */
package com.youplus.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Manish
 *
 */
@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
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
	
	/*
	 * unique entered by customer.
	 */
	@Column(name = "customer_id", unique = true)
	private String customerId;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
