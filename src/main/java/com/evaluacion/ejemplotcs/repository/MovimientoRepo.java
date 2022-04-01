package com.evaluacion.ejemplotcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.ejemplotcs.model.Movimiento;

@Repository
public interface MovimientoRepo extends JpaRepository<Movimiento,Integer>{

}
