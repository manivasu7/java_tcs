package com.ejercicio.java_tcs1.repository;

import com.ejercicio.java_tcs1.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Long> {
}
