package com.evaluacion.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.prueba.model.Country;

@Repository
public interface CuentaRepo extends JpaRepository<Country, Integer>{

}
