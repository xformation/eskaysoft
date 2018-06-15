package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.BusinessExecutive;


@Repository("businessexecutivesDao")
@Transactional
public interface BusinessExecutivesDao extends JpaRepository<BusinessExecutive, Long> {
}
