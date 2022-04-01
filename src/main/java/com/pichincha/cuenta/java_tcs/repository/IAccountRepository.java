package com.pichincha.cuenta.java_tcs.repository;

import com.pichincha.cuenta.java_tcs.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepository extends CrudRepository<Account, Integer> {
}
