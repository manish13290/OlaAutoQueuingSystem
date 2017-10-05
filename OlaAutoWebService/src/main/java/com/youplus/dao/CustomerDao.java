/**
 * 
 */
package com.youplus.dao;

import com.youplus.entity.CustomerEntity;

/**
 * @author Manish
 *
 */
public interface CustomerDao extends GenericDao<CustomerEntity, Long> {
	CustomerEntity findCustomerByCustomerId(String customerId);
}
