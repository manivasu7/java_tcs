package com.bankaccount.account.service.impl;

import com.bankaccount.account.dto.BankAccountMovementsDto;
import com.bankaccount.account.exception.NoResourceException;
import com.bankaccount.account.model.BankAccountMovements;
import com.bankaccount.account.repository.BankAccountMovementsRepository;
import com.bankaccount.account.service.BankAccountMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountMovementsServiceImpl implements BankAccountMovementsService {
    @Autowired
    BankAccountMovementsRepository bankAccountMovementsRepository;

    @Override
    public List<BankAccountMovementsDto> getAllBankAccountMovements() {
        List<BankAccountMovements> bankAccounts = bankAccountMovementsRepository.findAll();
        List<BankAccountMovementsDto> bankAccountsDtos = new ArrayList<>();
        bankAccounts.stream().forEach((bankAccount) -> {
            bankAccountsDtos.add(new BankAccountMovementsDto(bankAccount.getId(), bankAccount.getTransactionType(), bankAccount.getTransactionNumber(), bankAccount.getDescription(), bankAccount.getAccountInputOutput(), bankAccount.getAmount(), bankAccount.getDate()));
        });
        return bankAccountsDtos;
    }

    @Override
    public BankAccountMovementsDto createBankAccountMovement(BankAccountMovementsDto bankAccountMovementsDto) {
        return bankAccountMovementsRepository.save(bankAccountMovementsDto.getAsEntity()).getAsDto();
    }

    @Override
    public BankAccountMovementsDto updateBankAccountMovement(Long id, BankAccountMovementsDto bankAccountMovementsDto) throws NoResourceException {
        Optional<BankAccountMovements> bankAccountMovements = bankAccountMovementsRepository.findById(id);
        if (bankAccountMovements.isPresent()) {
            bankAccountMovements.get().setTransactionType(bankAccountMovementsDto.getTipoTransaccion());
            bankAccountMovements.get().setTransactionNumber(bankAccountMovementsDto.getNumeroTransaccion());
            bankAccountMovements.get().setDescription(bankAccountMovementsDto.getDescripcion());
            bankAccountMovements.get().setAccountInputOutput(bankAccountMovementsDto.getBeneficiarioOrdenante());
            bankAccountMovements.get().setAmount(bankAccountMovementsDto.getMonto());
            bankAccountMovements.get().setDate(bankAccountMovementsDto.getFecha());
            return bankAccountMovementsRepository.save(bankAccountMovements.get()).getAsDto();
        } else {
            throw new NoResourceException("No existe el movimiento con id : " + id);
        }
    }

    @Override
    public void deleteBankAccountMovement(Long id) throws NoResourceException {
        Optional<BankAccountMovements> bankAccountMovements = bankAccountMovementsRepository.findById(id);
        if (bankAccountMovements.isPresent()) {
            bankAccountMovementsRepository.delete(bankAccountMovements.get());
        } else {
            throw new NoResourceException("No existe el movimiento con id : " + id);
        }
    }
}