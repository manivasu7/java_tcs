package com.mayank.examproj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.examproj.dto.MovementDto;
import com.mayank.examproj.exception.NoResourceException;
import com.mayank.examproj.model.Movement;
import com.mayank.examproj.repository.MovementRepository;
import com.mayank.examproj.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {
	@Autowired
	MovementRepository movementRepository;

	@Override
	public List<MovementDto> getMovementsPorCuenta(long Cuenta) {
		List<Movement> movements = movementRepository.findByOrigin(Cuenta);
		List<Movement> movements1 = movementRepository.findByDestino(Cuenta);
		List<MovementDto> movementDto = new ArrayList<>();
		movements.stream().forEach((movement) -> {
			movementDto.add(movement.getAsTo());
		});
		movements1.stream().forEach((movement) -> {
			movementDto.add(movement.getAsTo());
		});

		return movementDto;
	}

	@Override
	public MovementDto createMovement(MovementDto movementDto) {
		return movementRepository.save(movementDto.getAsEntity()).getAsTo();
	}

	@Override
	public void deleteMovement(Long id) throws NoResourceException {
		Optional<Movement> movement = movementRepository.findById(id);
		if (movement.isPresent()) {
			movementRepository.delete(movement.get());
		} else {
			throw new NoResourceException("No existe la movement con id : " + id);
		}
	}

}
