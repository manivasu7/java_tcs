package com.bpichincha.java_tcs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpichincha.java_tcs.model.Account;
import com.bpichincha.java_tcs.repository.AccountRepository;
import com.bpichincha.java_tcs.service.AccountService;
@Service
public class AccountServicesImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Optional<Account> getAccountId(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public List<Account> getAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
		
	}

	@Override
	public Account updateAccount(Account account) {
		Optional<Account> updateAccountClient = accountRepository.findById(account.getId());
		updateAccountClient.get().setAccountNumber(account.getAccountNumber());
		updateAccountClient.get().setMontoCuenta(account.getMontoCuenta());
		updateAccountClient.get().setMovements(account.getMovements());
		return null;
	}



}
