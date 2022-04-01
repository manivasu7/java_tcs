package com.ejercicio.accounts.demoaccounts.service;

import java.util.List;

import com.ejercicio.accounts.demoaccounts.dto.MovementDto;
import com.ejercicio.accounts.demoaccounts.exception.NotFoundResourceException;

public interface MovementService {

	public List<MovementDto> getMovementByAccount();

	public void deleteMovement(Long id) throws NotFoundResourceException;

	public void getMovementByAccount(String account) throws NotFoundResourceException;
}
