package com.bpichincha.java_tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bpichincha.java_tcs.model.Account;

public interface AccountService {
	
	Optional<Account> getAccountId (Long id);
	
	List<Account> getAccount();
	
	Account addAccount(Account account);
	
	void deleteAccount(Long id);
	
	Account updateAccount(Account account);

}
