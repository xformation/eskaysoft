package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.CustomerWiseDiscounts;
@Repository("coustomerWiseDiscountDao")
@Transactional
public interface CustomerWiseDiscountsDao extends JpaRepository<CustomerWiseDiscounts, Long> {
	}

