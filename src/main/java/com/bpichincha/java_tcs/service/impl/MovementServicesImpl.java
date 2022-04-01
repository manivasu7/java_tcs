package com.bpichincha.java_tcs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpichincha.java_tcs.model.Movement;
import com.bpichincha.java_tcs.repository.MovementRepository;
import com.bpichincha.java_tcs.service.MovementServices;
@Service
public class MovementServicesImpl implements MovementServices{
	
	@Autowired 
	MovementRepository movementRepository;
	
	@Override
	public Optional<Movement> getMovementId(Long id) {
		return movementRepository.findById(id);
	}

	@Override
	public List<Movement> getMovement() {
		return movementRepository.findAll();
	}

	@Override
	public Movement addMovement(Movement movement) {
		return movementRepository.save(movement);
	}

	@Override
	public void deleteMovement(Long id) {
		movementRepository.deleteById(id);
		
	}

	@Override
	public Movement updateMovement(Movement movement) {
		Optional<Movement> updateMovementAccount = movementRepository.findById(movement.getId());
		updateMovementAccount.get().setCanalTransaccion(movement.getCanalTransaccion());
		updateMovementAccount.get().setMontoMovimiento(movement.getMontoMovimiento());
		return null;
	}

}