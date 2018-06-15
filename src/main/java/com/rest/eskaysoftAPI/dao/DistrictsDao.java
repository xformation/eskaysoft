package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.Districts;

@Repository("districtsDao")
@Transactional
public interface DistrictsDao extends JpaRepository<Districts, Long> {

}
