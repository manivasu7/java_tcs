package com.ejercicio.contabilidad.service.impl;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.dto.TransactionDto;
import com.ejercicio.contabilidad.exception.AccountException;
import com.ejercicio.contabilidad.model.Accounts;
import com.ejercicio.contabilidad.model.Transaction;
import com.ejercicio.contabilidad.repository.AccountRepo;
import com.ejercicio.contabilidad.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl {

    @Autowired
    private TransactionRepo transactionRepo;

    public List<TransactionDto> getTransactions() {

        List<Transaction> transaction =transactionRepo.findAll();

        return transaction.stream().map(c -> c.ToDto()).collect(Collectors.toList());

    }

    public TransactionDto saveTransaction(TransactionDto transaction) {

        return transactionRepo.save(transaction.toEntity()).ToDto();
    }


    public TransactionDto updateTransaction(TransactionDto transaction, int id_tran) throws AccountException {
        Optional<TransactionDto> transactionData = findTransaction(id_tran);
        if (transactionData.isPresent()) {
            Transaction objTransaction = transactionData.get().toEntity();
            objTransaction.setDescription(transaction.getDescription());
            objTransaction.setAmount_tran(transaction.getAmount_tran());
            objTransaction.setCredit_debit(transaction.getCredit_debit());
            return transactionRepo.save(objTransaction).ToDto();
        } else {
            throw new AccountException("Movimiento no existe");
        }

    }

    public void deleteTransaction(int id_tran) throws AccountException {
        Optional<TransactionDto> tutorialData = findTransaction(id_tran);
        if (tutorialData.isPresent()) {
            transactionRepo.deleteById(id_tran);
        } else {
            throw new AccountException("Movimiento no existe");
        }
    }

    public Optional<TransactionDto> findTransaction(Integer id_tran) {

        Optional<Transaction>  objTransaction = transactionRepo.findById(id_tran);
        Optional<TransactionDto> objTransactionDto;
        if(objTransaction.isPresent()) {

            objTransactionDto =  Optional.of(objTransaction.get().ToDto());
        }
        else {
            objTransactionDto = Optional.empty();
        }
        return objTransactionDto;
    }
}
