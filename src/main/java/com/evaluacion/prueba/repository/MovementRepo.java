package com.evaluacion.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evaluacion.prueba.model.State;

@Repository
public interface MovementRepo extends JpaRepository<State, Integer>{

}
