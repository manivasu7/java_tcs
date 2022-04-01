package com.ejercicio.contabilidad.repository;

import com.ejercicio.contabilidad.model.Accounts;
import com.ejercicio.contabilidad.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
