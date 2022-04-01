package com.eddu.java_tcs1.services;

import java.util.List;

import com.eddu.java_tcs1.exceptions.ResourceNotFoundException;
import com.eddu.java_tcs1.model.Movement;

public interface MovementService {

	
	public List<Movement> getAllMovements();
	public Movement getMovementId(Integer Id);
	public Movement saveOrUpdateMovement(Movement movement);
	public void deleteMovement(Integer id) throws ResourceNotFoundException;
	public void updateMovement(Movement movement, Integer id) throws ResourceNotFoundException;
}
