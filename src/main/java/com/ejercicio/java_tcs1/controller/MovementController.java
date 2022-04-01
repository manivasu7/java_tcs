package com.ejercicio.java_tcs1.controller;

import com.ejercicio.java_tcs1.dto.AccountDto;
import com.ejercicio.java_tcs1.dto.MovementDto;
import com.ejercicio.java_tcs1.service.MovementService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/movements")
public class MovementController {
    private final MovementService movementService;
    @PostMapping
    public ResponseEntity<MovementDto> saveProduct(@RequestBody MovementDto movementDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(movementService.saveMovement(movementDto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
