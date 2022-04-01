package com.ejercicio.accounts.demoaccounts.service;

import com.ejercicio.accounts.demoaccounts.dto.AccountDto;
import com.ejercicio.accounts.demoaccounts.exception.NotFoundResourceException;

public interface AccountService {

	public AccountDto createAccount(AccountDto accountDto);

	public AccountDto updateAccount(Long id, AccountDto accountDto) throws NotFoundResourceException;

	public AccountDto getAllMovement(Long id) throws NotFoundResourceException;

}
