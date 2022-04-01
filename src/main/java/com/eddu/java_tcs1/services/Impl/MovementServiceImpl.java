package com.eddu.java_tcs1.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eddu.java_tcs1.exceptions.ResourceNotFoundException;
import com.eddu.java_tcs1.model.Movement;
import com.eddu.java_tcs1.repository.MovementRepository;
import com.eddu.java_tcs1.services.MovementService;

public class MovementServiceImpl implements  MovementService{

	@Autowired
	private MovementRepository movementRepository;
	
	
	public List<Movement> getAllMovements() {
		
		return movementRepository.findAll();
	}


	
	public Movement getMovementId(Integer Id) {
	
		return movementRepository.findById(Id).get();
	}


	public Movement saveOrUpdateMovement(Movement movement) {

		return movementRepository.save(movement);
	}

	
	public void deleteMovement(Integer id) throws ResourceNotFoundException {
		movementRepository.deleteById(id);
		
	}

	
	public void updateMovement(Movement movement, Integer id) throws ResourceNotFoundException {
		movementRepository.save(movement);
		
	}

	
	
}
