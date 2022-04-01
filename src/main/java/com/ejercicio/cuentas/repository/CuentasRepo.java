package com.ejercicio.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.cuentas.model.Cuentas;

@Repository
public interface CuentasRepo extends JpaRepository<Cuentas, Integer> {

}
