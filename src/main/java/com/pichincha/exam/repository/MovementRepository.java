package com.pichincha.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pichincha.exam.model.Movement;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
	@Query("select m from Movement m")
	List<Movement> findByAccountNumber(String accountNumber);
}
