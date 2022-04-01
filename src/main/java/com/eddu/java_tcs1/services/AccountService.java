package com.eddu.java_tcs1.services;

import java.util.List;

import com.eddu.java_tcs1.exceptions.ResourceNotFoundException;
import com.eddu.java_tcs1.model.Account;

public interface AccountService {

	public List<Account> getAllAccounts();
	public Account getAccountId(Integer Id);
	public Account saveOrUpdateAccount(Account account);
	public void deleteAccount(Integer id) throws ResourceNotFoundException;
	public void updateAccount(Account account, Integer id) throws ResourceNotFoundException;
	
}
