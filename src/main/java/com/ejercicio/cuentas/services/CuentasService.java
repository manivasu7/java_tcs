package com.ejercicio.cuentas.services;

import java.util.List;
import java.util.Optional;

import com.ejercicio.cuentas.dto.CuentasDto;
import com.ejercicio.cuentas.exception.ResourceNotFoundException;

public interface CuentasService {

	public List<CuentasDto> getCuentas();

	public CuentasDto saveCuentas(CuentasDto cuenta);

	public CuentasDto update(CuentasDto cuenta, int id) throws ResourceNotFoundException;

	public void deleteCuentas(int id) throws ResourceNotFoundException;

	public Optional<CuentasDto> findCuentas(Integer id);
	
}
