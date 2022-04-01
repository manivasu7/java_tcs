package com.bpichincha.java_tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpichincha.java_tcs.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
