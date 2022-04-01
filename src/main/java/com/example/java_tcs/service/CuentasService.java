package com.example.java_tcs.service;

import java.util.List;
import java.util.Optional;

import com.example.java_tcs.dto.CuentasDto;
import com.example.java_tcs.exeption.ResourceNotFoundException;


public interface CuentasService {

	public List<CuentasDto> getCuentas();

	public CuentasDto saveCuentas(CuentasDto cuentas);

	public CuentasDto update(CuentasDto cuentas, int id) throws ResourceNotFoundException;

	public void deleteCuentas(int id) throws ResourceNotFoundException;

	public Optional<CuentasDto> findCuentas(Integer id);
}

