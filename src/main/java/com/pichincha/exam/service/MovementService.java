package com.pichincha.exam.service;

import java.util.List;

import com.pichincha.exam.dto.MovementDto;

public interface MovementService {
	
	MovementDto createMovement(MovementDto movement);

	void deleteMovement(Long movementId);

	List<MovementDto> findMovement(String accountNumber);
}
