package com.youplus.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.youplus.entity.DriverEntity;

@Repository
@Transactional
public class DriverDaoImpl extends GenericDaoImpl<DriverEntity, Long>implements DriverDao {

	public DriverDaoImpl() {
	}

}
