package com.pichincha.backend.practica.controller;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.dto.MovementDto;
import com.pichincha.backend.practica.model.Movement;
import com.pichincha.backend.practica.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class MovementController {
    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }
    @PostMapping
    public ResponseEntity<MovementDto> saveMovement(@RequestBody MovementDto movement){
        try {
            return new ResponseEntity<>(movementService.saveMovement(movement), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
