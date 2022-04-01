package com.evaluacion.prueba.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.evaluacion.prueba.dto.CuentaDto;
import com.evaluacion.prueba.exception.ResourceNotFoundException;

@Service
public interface CuentaService {
	
	public List<CuentaDto> getCuentas();

	public CuentaDto saveCuenta(CuentaDto cuenta);

	public CuentaDto update(CuentaDto cuenta, int id) throws ResourceNotFoundException;

	public void deleteCuenta(int id) throws ResourceNotFoundException;

	public Optional<CuentaDto> findCountry(Integer id);

}
