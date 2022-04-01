package com.pichincha.java_tcs_cpenriqu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pichincha.java_tcs_cpenriqu.model.Account;



@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

}