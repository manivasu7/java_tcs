package com.springboot.cuenta.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cuenta.crud.dao.ICuentaRepository;
import com.springboot.cuenta.crud.entity.Cuenta;

@Service
public class CuentaService {

	@Autowired
	private ICuentaRepository iCuentaRepository;
	
	public Cuenta createCuenta(Cuenta cuenta)
	{
		return iCuentaRepository.save(cuenta);
	}

	public List<Cuenta> createCuentas(List<Cuenta> cuentas)
	{
		return iCuentaRepository.saveAll(cuentas);
	}

	public Cuenta getCuenta(int id)
	{
		return iCuentaRepository.findById(id).orElse(null);
	}
	
	public List<Cuenta> getCuentas()
	{
		return iCuentaRepository.findAll();
	}

	public Cuenta updateCuenta(Cuenta cuenta)
	{
		Cuenta oldUser;
		Optional<Cuenta> optUser = iCuentaRepository.findById(cuenta.getSerialNo());
		if(optUser.isPresent())
		{
			oldUser = new Cuenta();
			oldUser.setNumeroCuenta(cuenta.getNumeroCuenta());		
			iCuentaRepository.save(oldUser);
		}
		else
		{
			return new Cuenta();
		}

		return oldUser;
	}
	
	public String deleteCuenta(int id)
	{
		iCuentaRepository.deleteById(id);
		 return "Cuenta got deleted";
	}


}
