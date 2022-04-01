package com.pichincha.cuenta.java_tcs.service;

import com.pichincha.cuenta.java_tcs.entity.Account;

import java.util.List;

public interface IAccountService {
    Account save(Account account) throws Exception;

    List<Account> findAccountList();
}
