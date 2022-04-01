package com.pichincha.tcsbank.controller;

import com.pichincha.tcsbank.model.Movement;
import com.pichincha.tcsbank.service.MovementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
public class MovementController {
    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping
    public ResponseEntity<List<Movement>> getMovements(){
        return new ResponseEntity(movementService.getMovements(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movement> saveMovement(@RequestBody Movement movement){
        return new ResponseEntity<>(movementService.saveMovement(movement), HttpStatus.CREATED);
    }


}
