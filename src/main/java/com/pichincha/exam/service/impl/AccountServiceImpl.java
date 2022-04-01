package com.pichincha.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.exam.dto.AccountDto;
import com.pichincha.exam.exception.AplicationException;
import com.pichincha.exam.exception.OperationInvalidException;
import com.pichincha.exam.exception.ResourceNotFoundException;
import com.pichincha.exam.model.Account;
import com.pichincha.exam.repository.AccountRepository;
import com.pichincha.exam.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto account) {

		List<Account> accountsFound = accountRepository.findByAccountNumber(account.getAccountNumber());
		if (accountsFound != null && !accountsFound.isEmpty()) {
			throw new OperationInvalidException("Cuenta ya existe", "accountNumber", account.getAccountNumber());
		}
		try {
			Account accountBdd = accountRepository.save(account.toEntity());
			return accountBdd.toDto();
		} catch (Exception e) {
			throw new AplicationException("Accounts", e);
		}
	}

	@Override
	public AccountDto updateAccount(AccountDto account, Long accountId) {
		Account accountInDb = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountId));
		
		accountInDb.setAccountNumber(account.getAccountNumber());
		accountInDb.setAccountType(account.getAccountType());
		accountInDb.setCurrency(account.getCurrency());
		
		
		Account accountUpdated = accountRepository.save(accountInDb);
		
		return accountUpdated.toDto();
	}

}
