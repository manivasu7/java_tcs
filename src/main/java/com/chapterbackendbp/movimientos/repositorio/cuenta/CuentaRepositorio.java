package com.chapterbackendbp.movimientos.repositorio.cuenta;

import com.chapterbackendbp.movimientos.entidades.Cuenta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long>{
    
}
