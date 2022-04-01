package com.bankaccount.account.repository;

import com.bankaccount.account.model.BankAccountMovements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountMovementsRepository extends JpaRepository<BankAccountMovements, Long> {

}