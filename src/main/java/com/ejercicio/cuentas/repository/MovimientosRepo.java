package com.ejercicio.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.cuentas.model.Movimientos;

@Repository
public interface MovimientosRepo extends JpaRepository<Movimientos, Integer> {

}
