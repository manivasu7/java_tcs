package com.pichincha.tcsbank.service;

import com.pichincha.tcsbank.model.Movement;

import java.util.List;

public interface MovementService {
    List<Movement> getMovements();
    Movement saveMovement(Movement movement);
}
