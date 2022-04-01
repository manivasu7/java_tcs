package com.springboot.cuenta.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cuenta.crud.entity.Cuenta;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {

}
