package com.example.java_tcs.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java_tcs.dto.CuentasDto;
import com.example.java_tcs.exeption.ResourceNotFoundException;
import com.example.java_tcs.model.Cuentas;
import com.example.java_tcs.repository.CuentasRepo;
import com.example.java_tcs.service.CuentasService;


@Service
public class CuentasServiceImpl implements CuentasService {

	@Autowired
	private CuentasRepo cuentasRepo;

	public List<CuentasDto> getCuentas() {
		
		List<Cuentas> objCuentas =cuentasRepo.findAll();
		
		return objCuentas.stream().map(c -> c.ToDto()).collect(Collectors.toList());
				
	}

	public CuentasDto saveCuentas(CuentasDto cuentas) {

		return cuentasRepo.save(cuentas.toEntity()).ToDto();
	}

	public CuentasDto update(CuentasDto cuentas, int id) throws ResourceNotFoundException {
		Optional<CuentasDto> tutorialData = findCuentas(id);
		if (tutorialData.isPresent()) {
			Cuentas objCuentas = tutorialData.get().toEntity();
			objCuentas.setName(cuentas.getName());
			objCuentas.setCode(cuentas.getCode());
			return cuentasRepo.save(objCuentas).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}

	public void deleteCuentas(int id) throws ResourceNotFoundException {
		Optional<CuentasDto> tutorialData = findCuentas(id);
		if (tutorialData.isPresent()) {
			cuentasRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

	public Optional<CuentasDto> findCuentas(Integer id) {
		
		Optional<Cuentas>  objCuentas = cuentasRepo.findById(id);
		Optional<CuentasDto> objCuentasDto;
		if(objCuentas.isPresent()) {
			
			objCuentasDto =  Optional.of(objCuentas.get().ToDto());
		}
		else {
			objCuentasDto = Optional.empty();
		}	
		return objCuentasDto;
	}
}

