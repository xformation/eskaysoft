package com.rest.eskaysoftAPI.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.eskaysoftAPI.entity.AccountInformation;

@Repository("accountInformationDao")
@Transactional
public interface AccountInformationDao extends JpaRepository<AccountInformation, Long> {

}
