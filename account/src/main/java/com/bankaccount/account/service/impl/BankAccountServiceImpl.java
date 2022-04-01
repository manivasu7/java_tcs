package com.bankaccount.account.service.impl;

import com.bankaccount.account.dto.BankAccountDto;
import com.bankaccount.account.exception.NoResourceException;
import com.bankaccount.account.model.BankAccount;
import com.bankaccount.account.repository.BankAccountRepository;
import com.bankaccount.account.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountDto> getAllBankAccount() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        List<BankAccountDto> bankAccountsDtos = new ArrayList<>();
        bankAccounts.stream().forEach((bankAccount) -> {
            bankAccountsDtos.add(new BankAccountDto(bankAccount.getId(), bankAccount.getAccountNumber(), bankAccount.getOpeningDate(), bankAccount.getCountableBalance(), bankAccount.getStatus(), bankAccount.getOwner(), bankAccount.getAccountType()));
        });
        return bankAccountsDtos;
    }

    @Override
    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
        return bankAccountRepository.save(bankAccountDto.getAsEntity()).getAsDto();
    }

    @Override
    public BankAccountDto updateBankAccount(Long id, BankAccountDto bankAccountDto) throws NoResourceException {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if (bankAccount.isPresent()) {
            bankAccount.get().setAccountNumber(bankAccountDto.getNumeroCuenta());
            bankAccount.get().setOpeningDate(bankAccountDto.getFechaApertura());
            bankAccount.get().setCountableBalance(bankAccountDto.getSaldoContable());
            bankAccount.get().setStatus(bankAccountDto.getEstado());
            bankAccount.get().setOwner(bankAccountDto.getPropietario());
            bankAccount.get().setAccountType(bankAccountDto.getTipoCuenta());
            return bankAccountRepository.save(bankAccount.get()).getAsDto();
        } else {
            throw new NoResourceException("No existe la cuenta bancaria con id : " + id);
        }
    }

    @Override
    public void deleteBankAccount(Long id) throws NoResourceException {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
        if (bankAccount.isPresent()) {
            bankAccountRepository.delete(bankAccount.get());
        } else {
            throw new NoResourceException("No existe la cuenta bancaria con id : " + id);
        }
    }
}