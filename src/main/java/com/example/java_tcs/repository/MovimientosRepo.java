package com.example.java_tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_tcs.model.Movimientos;

@Repository
public interface MovimientosRepo extends JpaRepository<Movimientos, Integer>{

}