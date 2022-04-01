package com.bp.cuenta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bp.cuenta.model.Cuenta;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer>{

}
