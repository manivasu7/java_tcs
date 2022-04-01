package com.pichincha.backend.practica.repository;

import com.pichincha.backend.practica.dto.MovementDto;
import com.pichincha.backend.practica.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonementRepository extends JpaRepository<MovementDto, Long> {
}
