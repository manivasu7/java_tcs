package com.bpichincha.java_tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bpichincha.java_tcs.model.Movement;

public interface MovementServices {
	
	Optional<Movement> getMovementId (Long id);
	
	List<Movement> getMovement();
	
	Movement addMovement(Movement movement);
	
	void deleteMovement(Long id);
	
	Movement updateMovement(Movement movement);
	

}
