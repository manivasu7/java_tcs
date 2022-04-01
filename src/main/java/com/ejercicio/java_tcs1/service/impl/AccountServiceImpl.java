package com.ejercicio.java_tcs1.service.impl;

import com.ejercicio.java_tcs1.dto.AccountDto;
import com.ejercicio.java_tcs1.repository.AccountRepository;
import com.ejercicio.java_tcs1.repository.MovementRepository;
import com.ejercicio.java_tcs1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        return accountRepository.save(accountDto.getAsEntity()).getAsDto();
    }
}
