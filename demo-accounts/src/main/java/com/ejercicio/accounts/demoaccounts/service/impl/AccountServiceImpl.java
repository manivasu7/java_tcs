package com.ejercicio.accounts.demoaccounts.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.accounts.demoaccounts.Repository.AccountRepository;
import com.ejercicio.accounts.demoaccounts.dto.AccountDto;
import com.ejercicio.accounts.demoaccounts.exception.NotFoundResourceException;
import com.ejercicio.accounts.demoaccounts.model.Account;
import com.ejercicio.accounts.demoaccounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		return accountRepository.save(accountDto.getAsEntity()).getAsTo();
	}

	@Override
	public AccountDto updateAccount(Long id, AccountDto accountDto) throws NotFoundResourceException {
		// TODO Auto-generated method stub
		Account accountOld = null;
		Optional<Account> optionalAccount = accountRepository.findById(id);
		if (optionalAccount.isPresent()) {
			accountOld = optionalAccount.get();
			accountOld.setName(accountDto.getName());
			accountOld.setBalance(accountDto.getBalance());
			accountOld.setTypeInteres(accountDto.getTypeInteres());
			accountOld.setTypeAccount(accountDto.getTypeAccount());
			return accountRepository.save(accountOld).getAsTo();
		} else {
			throw new NotFoundResourceException("No existe la cuenta con id : " + id);
		}
	}

	@Override
	public AccountDto getAllMovement(Long id) throws NotFoundResourceException {
		Optional<Account> accountOptinal = accountRepository.findById(id);
		if (accountOptinal.isPresent()) {
			return accountOptinal.get().getAsTo();
		} else {
			throw new NotFoundResourceException("No existe el id");
		}
	}

}
