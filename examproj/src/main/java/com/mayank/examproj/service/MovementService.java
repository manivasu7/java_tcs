package com.mayank.examproj.service;

import java.util.List;

import com.mayank.examproj.dto.MovementDto;
import com.mayank.examproj.exception.NoResourceException;

public interface MovementService {
	public List<MovementDto> getMovementsPorCuenta(long cuenta);

	public MovementDto createMovement(MovementDto movementDto);

	public void deleteMovement(Long id) throws NoResourceException;

}
