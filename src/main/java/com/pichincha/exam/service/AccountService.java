package com.pichincha.exam.service;

import com.pichincha.exam.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto account);

	AccountDto updateAccount(AccountDto account, Long accountId);

}
