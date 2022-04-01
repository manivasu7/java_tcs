package com.bankaccount.account.service;

import com.bankaccount.account.dto.BankAccountMovementsDto;
import com.bankaccount.account.exception.NoResourceException;

import java.util.List;

public interface BankAccountMovementsService {
    List<BankAccountMovementsDto> getAllBankAccountMovements();

    BankAccountMovementsDto createBankAccountMovement(BankAccountMovementsDto bankAccountMovementsDto);

    BankAccountMovementsDto updateBankAccountMovement(Long id, BankAccountMovementsDto bankAccountMovementsDto) throws NoResourceException;

    void deleteBankAccountMovement(Long id) throws NoResourceException;
}