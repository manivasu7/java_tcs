package com.pichincha.tcsbank.repository;

import com.pichincha.tcsbank.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement,Long> {
}
