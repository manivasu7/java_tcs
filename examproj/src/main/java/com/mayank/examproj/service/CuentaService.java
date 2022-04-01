package com.mayank.examproj.service;

import java.util.List;

import com.mayank.examproj.dto.CuentaDto;
import com.mayank.examproj.exception.NoResourceException;

public interface CuentaService {
	public List<CuentaDto> getAllCuentas();

	public CuentaDto createCuenta(CuentaDto clientDto);

	public CuentaDto updateCuenta(Long id, CuentaDto clientDto) throws NoResourceException;

	public void deleteCuenta(Long id) throws NoResourceException;

}
