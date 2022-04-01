package com.example.java_tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_tcs.model.Cuentas;

@Repository
public interface CuentasRepo extends JpaRepository<Cuentas, Integer> {

}
