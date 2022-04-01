package com.ejercicio.accounts.demoaccounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.accounts.demoaccounts.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
