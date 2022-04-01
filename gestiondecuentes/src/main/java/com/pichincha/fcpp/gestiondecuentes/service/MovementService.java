package com.pichincha.fcpp.gestiondecuentes.service;

import com.pichincha.fcpp.gestiondecuentes.entity.MovementsEntity;

public interface MovementService {

	public MovementsEntity createMovement(MovementsEntity movementsEntity)  throws Exception ;

	public String deleteMovement(Integer movementId) throws Exception ;

	
}
