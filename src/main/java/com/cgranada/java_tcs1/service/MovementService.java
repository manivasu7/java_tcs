package com.cgranada.java_tcs1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgranada.java_tcs1.model.Movement;
import com.cgranada.java_tcs1.repository.MovementRepo;


@Service
public class MovementService {
@Autowired
private MovementRepo movementRepo;

public List<Movement> getmMovements()
{
	return movementRepo.findAll();
}

public Movement save(Movement movement) {

	return movementRepo.save(movement);
}

public void delete(int id)
{
	movementRepo.deleteById(id);
}

//updating a record
public void update(Movement movement, int id)
{
			
	movementRepo.save(movement);
}

public Optional<Movement> findById(Integer id) {				
	
	return movementRepo.findById(id);
}

}
