package com.mayank.examproj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.examproj.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
	List<Movement> findByOrigin(long cuenta);

	List<Movement> findByDestino(long destino);

}
