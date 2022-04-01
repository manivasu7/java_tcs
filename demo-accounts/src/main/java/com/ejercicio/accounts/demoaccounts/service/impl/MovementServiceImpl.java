package com.ejercicio.accounts.demoaccounts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.accounts.demoaccounts.Repository.MovementRepository;
import com.ejercicio.accounts.demoaccounts.dto.MovementDto;
import com.ejercicio.accounts.demoaccounts.exception.NotFoundResourceException;
import com.ejercicio.accounts.demoaccounts.model.Movement;
import com.ejercicio.accounts.demoaccounts.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRepository;

	@Override
	public void deleteMovement(Long id) throws NotFoundResourceException {
		// TODO Auto-generated method stub
		Optional<Movement> movementOptinal = movementRepository.findById(id);
		if (movementOptinal.isPresent()) {
			movementRepository.delete(movementOptinal.get());
		} else {
			throw new NotFoundResourceException("No existe el cliente con id : " + id);
		}

	}

	@Override
	public List<MovementDto> getMovementByAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getMovementByAccount(String account) throws NotFoundResourceException {
		// TODO Auto-generated method stub
		
	}

}
