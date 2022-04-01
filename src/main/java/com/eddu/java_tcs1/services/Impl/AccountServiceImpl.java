package com.eddu.java_tcs1.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddu.java_tcs1.model.Account;
import com.eddu.java_tcs1.repository.AccountRepository;
import com.eddu.java_tcs1.services.AccountService;

@Service
public class AccountServiceImpl  implements AccountService{
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountId(Integer Id) {
		return accountRepository.findById(Id).get();
	}

	public Account saveOrUpdateAccount(Account account) {
		return  accountRepository.save(account);
	}

	public void deleteAccount(Integer id) {
		accountRepository.deleteById(id);
	}

	public void updateAccount(Account account, Integer id) {
		accountRepository.save(account);
	}

}
