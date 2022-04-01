package com.pichincha.backend.practica.service;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.exception.ResourceNotFoundException;

public interface AcountService {
    AcountDto saveAcount(AcountDto acountDto);
    AcountDto updateAcount(long id, AcountDto acountDto) throws ResourceNotFoundException;
}
