package com.pichincha.backend.practica.service.impl;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.exception.ResourceNotFoundException;
import com.pichincha.backend.practica.model.Acount;
import com.pichincha.backend.practica.repository.AcountRepository;
import com.pichincha.backend.practica.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AcountServiceImpl implements AcountService {
    @Autowired
    private final AcountRepository acountRepository;

    public AcountServiceImpl(AcountRepository acountRepository) {
        this.acountRepository = acountRepository;
    }

    @Override
    public AcountDto saveAcount(AcountDto acountDto) {
        return acountRepository.save(acountDto);
    }

    @Override
    public AcountDto updateAcount(long id, AcountDto acountDto) throws ResourceNotFoundException {
        /*AcountDto acountBdd = acountRepository.findById(id).orElse(null);
        if(acountBdd == null){
            throw new ResourceNotFoundException("No exists");

            acountBdd.setNameClient(acountDto.getNameClient());
            acountBdd.setLastnameClient(acountDto.getLastnameClient());
            acountBdd.setNumber(acountDto.getNumber());
            acountBdd.setType(acountDto.getNumber());
            acountBdd.setMonto(acountDto.getMonto());*/
        return null;

        }
    }


