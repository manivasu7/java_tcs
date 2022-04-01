package com.prueba.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.cliente.model.CuentasDeClientes;

public interface ICuentaClienteRepository extends JpaRepository<CuentasDeClientes, Long> {

}
