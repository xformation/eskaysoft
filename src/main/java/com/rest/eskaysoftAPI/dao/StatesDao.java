package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.States;

@Repository("StatesDao")
@Transactional
public interface StatesDao extends JpaRepository<States, Long> {
}
