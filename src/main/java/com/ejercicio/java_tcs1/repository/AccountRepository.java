package com.ejercicio.java_tcs1.repository;


import com.ejercicio.java_tcs1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
