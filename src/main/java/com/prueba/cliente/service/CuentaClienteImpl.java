package com.prueba.cliente.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.CuentasDeClientes;
import com.prueba.cliente.repository.ICuentaClienteRepository;

@Service
public class CuentaClienteImpl implements ICuentaClienteService{
	
	@Autowired
	ICuentaClienteRepository cuentaClienteRepository;
	
	@Override
	public List<CuentasDeClientes> getAllCuentas() {
		List<CuentasDeClientes> cuentas = cuentaClienteRepository.findAll();
		return cuentas;
	}

	
	@Override
	public CuentasDeClientes createCuenta(CuentasDeClientes cuenta) {

		return cuentaClienteRepository.save(cuenta);
	}

	@Override
	public CuentasDeClientes updateCuenta(Long id, CuentasDeClientes cuenta) throws NoResourceException {

		Optional<CuentasDeClientes> cuentaBusqueda = cuentaClienteRepository.findById(id);
        if (cuentaBusqueda.isPresent()) {
            return cuentaClienteRepository.save(cuenta);
        }
        else {
            throw  new NoResourceException("No existe la cuenta con id : "+id);
        }
        
	}
	
	@Override
	public void deleteCuenta(Long id) throws NoResourceException {

		Optional<CuentasDeClientes> cuentaBusqueda = cuentaClienteRepository.findById(id);
		if(cuentaBusqueda.isPresent()){
			cuentaClienteRepository.delete(cuentaBusqueda.get());
        }else{
            throw  new NoResourceException("No existe la cuenta con id : "+id);
        }
	}
	

}
