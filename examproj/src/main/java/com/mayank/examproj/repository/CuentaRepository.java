package com.mayank.examproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayank.examproj.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
