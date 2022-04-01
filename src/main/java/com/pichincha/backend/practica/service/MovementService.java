package com.pichincha.backend.practica.service;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.dto.MovementDto;
import com.pichincha.backend.practica.model.Movement;

import java.util.List;

public interface MovementService {

    List<MovementDto> getAllMovement();
    MovementDto saveMovement(MovementDto movementDto);
    void deleteMovement(Long id);
}
