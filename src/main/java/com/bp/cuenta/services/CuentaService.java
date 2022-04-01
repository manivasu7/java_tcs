package com.bp.cuenta.services;

import java.util.List;
import java.util.Optional;

import com.bp.cuenta.dto.CuentaDto;
import com.bp.cuenta.services.exception.ResourceNotFoundException;

public interface CuentaService {
	public List<CuentaDto> getCuenta();
	public CuentaDto update (CuentaDto cuenta, int id) throws ResourceNotFoundException;
	public CuentaDto saveCuenta (CuentaDto cuenta);
	public void deleteCuenta (int id) throws ResourceNotFoundException;; 
	public Optional<CuentaDto> findCuenta(Integer id);

}
