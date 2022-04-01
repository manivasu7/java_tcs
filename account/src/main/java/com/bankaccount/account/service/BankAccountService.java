package com.bankaccount.account.service;

import com.bankaccount.account.dto.BankAccountDto;
import com.bankaccount.account.exception.NoResourceException;

import java.util.List;

public interface BankAccountService {
    List<BankAccountDto> getAllBankAccount();

    BankAccountDto createBankAccount(BankAccountDto bankAccountDto);

    BankAccountDto updateBankAccount(Long id, BankAccountDto bankAccountDto) throws NoResourceException;

    void deleteBankAccount(Long id) throws NoResourceException;
}