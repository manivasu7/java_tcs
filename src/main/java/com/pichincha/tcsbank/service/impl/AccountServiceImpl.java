package com.pichincha.tcsbank.service.impl;

import com.pichincha.tcsbank.model.Account;
import com.pichincha.tcsbank.repository.AccountRepository;
import com.pichincha.tcsbank.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id,Account account) {
        Account accountDb = accountRepository.findById(id).orElse(null);
        if(accountDb==null) return null;
        accountDb.setOwner(account.getOwner());
        accountDb.setBalance(account.getBalance());
        return accountRepository.save(accountDb);
    }
}
