package com.pichincha.cuenta.java_tcs.service;

import com.pichincha.cuenta.java_tcs.entity.Movement;
import com.pichincha.cuenta.java_tcs.repository.IMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class MovementService implements IMovementService {

    @Autowired
    private IMovementRepository iMovementRepository;

    public MovementService(IMovementRepository iAccountMovementRepository) {
        this.iMovementRepository = iAccountMovementRepository;
    }

    public List<Movement> findAccountMovementByAccountId(Integer accountId) throws Exception {
        return (List<Movement>) iMovementRepository.findAllById(Collections.singleton(accountId));
    }

}
