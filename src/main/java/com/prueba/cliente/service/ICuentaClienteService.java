package com.prueba.cliente.service;

import java.util.List;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.CuentasDeClientes;

public interface ICuentaClienteService {
	public List<CuentasDeClientes> getAllCuentas();
    public CuentasDeClientes createCuenta(CuentasDeClientes cuenta);
    public CuentasDeClientes updateCuenta(Long id, CuentasDeClientes cuenta) throws NoResourceException;
    public void deleteCuenta(Long id) throws NoResourceException;
}
