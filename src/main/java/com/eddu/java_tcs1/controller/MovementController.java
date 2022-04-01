package com.eddu.java_tcs1.controller;

import java.util.List;

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

import com.eddu.java_tcs1.exceptions.ResourceNotFoundException;
import com.eddu.java_tcs1.model.Movement;
import com.eddu.java_tcs1.services.Impl.MovementServiceImpl;

@RestController
@RequestMapping("/api/v1/movement")
public class MovementController {
	
	@Autowired
	MovementServiceImpl movementService;
	
	@GetMapping("getMovements")
	private List<Movement> getAllMovements(){
		return movementService.getAllMovements();
	}
	
	@GetMapping("getMovement/{movementid}")
	private Movement getMovement(@PathVariable("movementid") Integer movementid){
		return movementService.getMovementId(movementid);
	}
	
	@PostMapping("/createMovement")
	public ResponseEntity<?> postCountrie(@RequestBody Movement movement) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movementService.saveOrUpdateMovement(movement));

	}
	
	@DeleteMapping("deleteMovementt/{movementid}")
	private void deleteMovement(@PathVariable("movementid") Integer movementid) throws ResourceNotFoundException{
		movementService.deleteMovement(movementid);
	}
			
	@PutMapping("/updateMovement/{movementid}")
	private Movement updateMovement(@PathVariable("movementid") Integer movementid,Movement movement)throws ResourceNotFoundException{   
	  
		movementService.updateMovement(movement, movementid);
	   return movement;  
	} 
	

}
