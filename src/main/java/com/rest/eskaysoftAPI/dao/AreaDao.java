package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.Area;

@Repository("AreaDao")
@Transactional
public interface AreaDao extends JpaRepository<Area, Long> {

}