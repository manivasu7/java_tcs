package com.prueba.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.cliente.model.MovimientoDeCuentasDeClientes;

public interface IMovimientosCuentasClientes extends JpaRepository<MovimientoDeCuentasDeClientes, Long> {

}
