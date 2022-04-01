package com.pichincha.exam.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.exam.dto.MovementDto;
import com.pichincha.exam.exception.ResourceNotFoundException;
import com.pichincha.exam.model.Movement;
import com.pichincha.exam.repository.MovementRepository;
import com.pichincha.exam.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {
	@Autowired
	private MovementRepository movementRepository;

	@Override
	public MovementDto createMovement(MovementDto movement) {
		Movement movementInBdd = movementRepository.save(movement.toEntity());
		return movementInBdd.toDto();
	}

	@Override
	public void deleteMovement(Long movementId) {
		Movement movemntInDb = movementRepository.findById(movementId).orElseThrow(()-> new ResourceNotFoundException("Movement", "movementId", movementId));
		movementRepository.delete(movemntInDb);
	}

	@Override
	public List<MovementDto> findMovement(String accountNumber) {
		List<Movement> movimientos = movementRepository.findByAccountNumber(accountNumber);
		movimientos.stream().forEach(m -> m.setAccount(null));
		return movimientos.stream().map(m -> m.toDto()).collect(Collectors.toList());
//		return null;
	}

}
