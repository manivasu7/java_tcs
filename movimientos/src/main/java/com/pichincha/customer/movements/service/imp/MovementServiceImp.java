/**
 * 
 */
package com.pichincha.customer.movements.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.customer.movements.entity.MovementEntity;
import com.pichincha.customer.movements.repository.MovementRepository;
import com.pichincha.customer.movements.service.MovementService;


/**
 * @author jjoseph
 *
 */
@Service
public class MovementServiceImp implements MovementService {
	
	@Autowired
	MovementRepository movementRepository;
	
	@Override
	public List<MovementEntity> getAllAccountsMovements() {
		List<MovementEntity> movement = (List<MovementEntity>) movementRepository.findAll();
		
		return movement;
	}
	
	public MovementEntity saveTutorial(MovementEntity movements) {
		MovementEntity movement = movementRepository.save(new MovementEntity());
		return movement;
	}


}
