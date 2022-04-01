package com.mayank.examproj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayank.examproj.dto.CuentaDto;
import com.mayank.examproj.exception.NoResourceException;
import com.mayank.examproj.model.Cuenta;
import com.mayank.examproj.repository.CuentaRepository;
import com.mayank.examproj.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {
	@Autowired
	CuentaRepository cuentaRepository;

	public List<CuentaDto> getAllCuentas() {
		List<Cuenta> cuentas = cuentaRepository.findAll();
		List<CuentaDto> cuentaDtos = new ArrayList<>();
		cuentas.stream().forEach((cuenta) -> {
			cuentaDtos.add(cuenta.getAsTo());
		});
		return cuentaDtos;
	}

	@Override
	public CuentaDto createCuenta(CuentaDto cuentaDto) {
		return cuentaRepository.save(cuentaDto.getAsEntity()).getAsTo();
	}

	@Override
	public CuentaDto updateCuenta(Long id, CuentaDto cuentaDto) throws NoResourceException {
		Optional<Cuenta> cuenta = cuentaRepository.findById(id);
		if (cuenta.isPresent()) {
			cuenta.get().setNumeroCuenta(cuentaDto.getNumeroCuenta());
			cuenta.get().setNombre(cuentaDto.getNombre());
			cuenta.get().setApellido(cuentaDto.getApellido());
			cuenta.get().setTipoCuenta(cuentaDto.getTipoCuenta());
			return cuentaRepository.save(cuenta.get()).getAsTo();
		} else {
			throw new NoResourceException("No existe la persona con id : " + id);
		}
	}

	@Override
	public void deleteCuenta(Long id) throws NoResourceException {
		Optional<Cuenta> cuenta = cuentaRepository.findById(id);
		if (cuenta.isPresent()) {
			cuentaRepository.delete(cuenta.get());
		} else {
			throw new NoResourceException("No existe la persona con id : " + id);
		}
	}

}
