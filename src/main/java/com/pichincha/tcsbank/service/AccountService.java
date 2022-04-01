package com.pichincha.tcsbank.service;

import com.pichincha.tcsbank.model.Account;

import java.util.List;
import java.util.Set;

public interface AccountService {
    Account saveAccount(Account account);
    Account updateAccount(Long id, Account account);
}
