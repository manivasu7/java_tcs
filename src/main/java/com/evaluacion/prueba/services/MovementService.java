package com.evaluacion.prueba.services;

import java.awt.Taskbar.State;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluacion.prueba.model.Movement;
import com.evaluacion.prueba.repository.MovementRepo;

public interface MovementService {

	@Autowired
	private MovementRepo movementRepo;
	
	public List<Movement> getMovement()
	{
		return movementRepo.findAll();
	}
	
	public State save(Movement movement) {

		return movementRepo.save(movement);
	}
	
	public void delete(int id)
	{
		movementRepo.deleteById(id);
	}

	public void update(Movement movement, int id)
	{
		movementRepo.save(movement);
	}

	public Optional<State> findById(Integer id) {				
		
		return movementRepo.findById(id);
	}
}
