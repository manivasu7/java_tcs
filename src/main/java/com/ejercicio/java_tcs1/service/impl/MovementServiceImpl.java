package com.ejercicio.java_tcs1.service.impl;

import com.ejercicio.java_tcs1.dto.MovementDto;
import com.ejercicio.java_tcs1.repository.MovementRepository;
import com.ejercicio.java_tcs1.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementServiceImpl implements MovementService {

    private final MovementRepository movementRepository;

    @Autowired
    public MovementServiceImpl(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public MovementDto saveMovement(MovementDto movementDto) {
         return movementRepository.save(movementDto.getAsEntity()).getAsDto();
    }
}
