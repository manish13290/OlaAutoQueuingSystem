package com.youplus.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.youplus.entity.CustomerEntity;

@Repository
@Transactional
public class CustomerDaoImpl extends GenericDaoImpl<CustomerEntity, Long>implements CustomerDao {

	public CustomerDaoImpl() {
	}

	@Override
	public CustomerEntity findCustomerByCustomerId(String customerId) {
		Query query = currentSession().createQuery("from CustomerEntity where customerId = :customerId");
		query.setParameter("customerId", customerId);
		List<CustomerEntity> customerList = query.list();
		if (customerList != null && !customerList.isEmpty()) {
			return customerList.get(0);
		}
		return null;
	}

}
