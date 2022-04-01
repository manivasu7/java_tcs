package com.bpichincha.java_tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpichincha.java_tcs.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long>{

}
