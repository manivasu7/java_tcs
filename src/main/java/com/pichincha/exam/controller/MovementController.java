package com.pichincha.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.exam.dto.MovementDto;
import com.pichincha.exam.service.MovementService;

@RestController
@RequestMapping("/api/v1/acounts/movements")
public class MovementController {

	@Autowired
	private MovementService movementService;
	
	@PostMapping
	public ResponseEntity<?> createMovement(@RequestBody MovementDto movement) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movementService.createMovement(movement));
	}
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<?> getMovement(@PathVariable(name = "accountNumber") String accountNumber) {
		return ResponseEntity.ok(movementService.findMovement(accountNumber));
	}

	@DeleteMapping("/{accountNumber}")
	public ResponseEntity<?> deleteMovement(@PathVariable(value = "accountNumber") Long accountNumber) {
		movementService.deleteMovement(accountNumber);
		return new ResponseEntity<String>("Se elimino el movimiento", HttpStatus.OK);

	}
}
