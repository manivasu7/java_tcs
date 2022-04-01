package com.ejercicio.cuentas.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.cuentas.dto.CuentasDto;
import com.ejercicio.cuentas.exception.ResourceNotFoundException;
import com.ejercicio.cuentas.model.Cuentas;
import com.ejercicio.cuentas.repository.CuentasRepo;
import com.ejercicio.cuentas.services.CuentasService;

@Service
public class CuentasServiceImpl implements CuentasService {
	@Autowired
	private CuentasRepo cuentaRepo;
	
	public List<CuentasDto> getCuentas() {
		List<Cuentas> objCountry =cuentaRepo.findAll();
		return objCountry.stream().map(c -> c.ToDto()).collect(Collectors.toList());
	}
	
	public CuentasDto saveCuentas(CuentasDto cuenta) {
		return cuentaRepo.save(cuenta.toEntity()).ToDto();
	}	
	
	public CuentasDto update(CuentasDto cuenta, int id) throws ResourceNotFoundException {
		Optional<CuentasDto> tutorialData = findCuentas(id);
		if (tutorialData.isPresent()) {
			Cuentas objCuenta = tutorialData.get().toEntity();
			objCuenta.setNombre_cliente(cuenta.getNombre_cliente());
			objCuenta.setCiudad(cuenta.getCiudad());
			objCuenta.setOcupacion(cuenta.getOcupacion());
			return cuentaRepo.save(objCuenta).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}
	
	public void deleteCuentas(int id) throws ResourceNotFoundException {
		Optional<CuentasDto> tutorialData = findCuentas(id);
		if (tutorialData.isPresent()) {
			cuentaRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}	
	
	public Optional<CuentasDto> findCuentas(Integer id) {
		Optional<Cuentas>  objCuenta = cuentaRepo.findById(id);
		Optional<CuentasDto> objCuentaDto;
		if(objCuenta.isPresent()) {
			objCuentaDto =  Optional.of(objCuenta.get().ToDto());
		}
		else {
			objCuentaDto = Optional.empty();
		}	
		return objCuentaDto;
	}	
	
	
}
