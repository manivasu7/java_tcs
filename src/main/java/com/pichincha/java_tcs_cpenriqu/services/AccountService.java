package com.pichincha.java_tcs_cpenriqu.services;

import java.util.List;
import java.util.Optional;

import com.pichincha.java_tcs_cpenriqu.dto.AccountDto;
import com.pichincha.java_tcs_cpenriqu.exception.ResourceNotFoundException;

public interface AccountService {

	public List<AccountDto> getAccounts();

	public AccountDto saveAccount(AccountDto account);

	public AccountDto update(AccountDto account, int id) throws ResourceNotFoundException;

	public void deleteAccount(int id) throws ResourceNotFoundException;

	public Optional<AccountDto> findAccount(Integer id);
}