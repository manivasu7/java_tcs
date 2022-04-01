package com.pichincha.backend.practica.service.impl;

import com.pichincha.backend.practica.dto.MovementDto;
import com.pichincha.backend.practica.repository.MonementRepository;
import com.pichincha.backend.practica.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    private final MonementRepository monementRepository;

    public MovementServiceImpl(MonementRepository monementRepository) {
        this.monementRepository = monementRepository;
    }

    @Override
    public List<MovementDto> getAllMovement() {
        return monementRepository.findAll();
    }

    @Override
    public MovementDto saveMovement(MovementDto movementDto) {
        return monementRepository.save(movementDto);
    }

    @Override
    public void deleteMovement(Long id) {
        monementRepository.deleteById(id);
    }
}
