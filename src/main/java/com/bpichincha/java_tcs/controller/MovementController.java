package com.bpichincha.java_tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bpichincha.java_tcs.model.Movement;
import com.bpichincha.java_tcs.service.MovementServices;

@RestController
@RequestMapping("/api/v1")
public class MovementController {
	
	@Autowired
	MovementServices movementServices;
	
	@GetMapping("/movement")
	public ResponseEntity getAllMovement() {
		return new ResponseEntity(movementServices.getMovement(), HttpStatus.OK);
		
	}	
	
	@PostMapping("/movement")
	public ResponseEntity addMovement(@RequestBody Movement movement) {
		return new ResponseEntity(movementServices.addMovement(movement), HttpStatus.CREATED);
	}

	@GetMapping("/movement/{id}")
	public ResponseEntity getMovement(@PathVariable Long id) {
		return new ResponseEntity(movementServices.getMovementId(id), HttpStatus.OK);
	}

	@DeleteMapping("/movement/{id}")
	public ResponseEntity deleteMovement(@PathVariable Long id) {
		movementServices.deleteMovement(id);
		return new ResponseEntity("Movement deleted", HttpStatus.OK);
	}

	@PutMapping("/movement/{id}")
	public ResponseEntity updateMovement(@RequestBody Movement movement, @PathVariable Long id) {
		return new ResponseEntity(movementServices.updateMovement(movement), HttpStatus.OK);
	}	

}
