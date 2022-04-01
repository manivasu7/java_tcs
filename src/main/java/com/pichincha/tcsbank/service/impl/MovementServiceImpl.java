package com.pichincha.tcsbank.service.impl;

import com.pichincha.tcsbank.model.Movement;
import com.pichincha.tcsbank.repository.MovementRepository;
import com.pichincha.tcsbank.service.MovementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {
    private final MovementRepository movementRepository;

    public MovementServiceImpl(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public List<Movement> getMovements() {
        return movementRepository.findAll();
    }

    @Override
    public Movement saveMovement(Movement movement) {
        return movementRepository.save(movement);
    }
}
