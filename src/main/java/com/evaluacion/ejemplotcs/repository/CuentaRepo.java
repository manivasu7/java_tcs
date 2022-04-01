package com.evaluacion.ejemplotcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.ejemplotcs.model.Cuenta;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta,Integer> {
	
}
