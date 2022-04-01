package com.pichincha.customer.movements.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.customer.movements.entity.MovementEntity;
import com.pichincha.customer.movements.service.MovementService;

/**
 * @author jjoseph
 *
 */

@RestController
@RequestMapping("/api")
public class MovementController {
	
	@Autowired
	MovementService movementService;
	
	@GetMapping("/getAllMovementDetails")
	public ResponseEntity<List<MovementEntity>> getAllAccountDetails() {
		try {
			List<MovementEntity> movements = new ArrayList<MovementEntity>();
			movements = movementService.getAllAccountsMovements();
				
			if (movements.isEmpty()) {
				return new ResponseEntity<List<MovementEntity>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<MovementEntity>>(movements, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/createMovements")
	public ResponseEntity<MovementEntity> createMovement(@RequestBody MovementEntity movement) {
		try {
			MovementEntity movements = movementService.saveTutorial(movement);
			return new ResponseEntity<>(movements, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
