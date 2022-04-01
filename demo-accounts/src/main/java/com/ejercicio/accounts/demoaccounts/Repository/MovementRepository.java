package com.ejercicio.accounts.demoaccounts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejercicio.accounts.demoaccounts.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {



}
