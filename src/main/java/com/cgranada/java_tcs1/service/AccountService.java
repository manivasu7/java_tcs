package com.cgranada.java_tcs1.service;

import java.util.List;
import java.util.Optional;
import com.cgranada.java_tcs1.dto.AccountDto;
import com.cgranada.java_tcs1.exception.ResourceNotFoundException;
;

public interface AccountService {
	public List<AccountDto> getAccount();
	public AccountDto saveAccount(AccountDto accountDto) ;
	
	
	public AccountDto updateAccount(AccountDto account, Integer id) throws ResourceNotFoundException;
	public void deleteAccount(Integer id) throws ResourceNotFoundException;
	public Optional<AccountDto> findAccount(Integer id);
}
