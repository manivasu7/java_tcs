package com.prueba.cliente.service;

import java.util.List;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.MovimientoDeCuentasDeClientes;

public interface IMovimientosCuentasService {
	public List<MovimientoDeCuentasDeClientes> getAllMovimientos();
    public MovimientoDeCuentasDeClientes createMovimiento(MovimientoDeCuentasDeClientes movimiento);
    public MovimientoDeCuentasDeClientes updateMovimiento(Long id, MovimientoDeCuentasDeClientes movimiento) throws NoResourceException;
    public void deleteMovimiento(Long id) throws NoResourceException;
}
