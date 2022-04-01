package com.ejercicio.contabilidad.service;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.dto.TransactionDto;
import com.ejercicio.contabilidad.exception.AccountException;
import com.ejercicio.contabilidad.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public List<TransactionDto> getTransactions();

    public TransactionDto saveTransaction(TransactionDto transaction);

    public TransactionDto updateTransaction(TransactionDto transaction, int id_tran) throws AccountException;

    public void deleteTransaction(int id_tran) throws AccountException;

    public Optional<TransactionDto> findTransaction(Integer id_tran);
}
