package com.chapterbackendbp.movimientos.servicio.Impl;

import java.util.List;
import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Cuenta;
import com.chapterbackendbp.movimientos.repositorio.cuenta.CuentaRepositorio;
import com.chapterbackendbp.movimientos.servicio.CuentaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaServicioImpl implements CuentaServicio{

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    @Override
    public List<Cuenta> cuentas() {      
        return cuentaRepositorio.findAll();
    }

    @Override
    public Optional<Cuenta> buscarPorId(long id) {
        return Optional.ofNullable(cuentaRepositorio.getById(id));
    }

    @Override
    public Cuenta guardarCuenta(Cuenta c) {
        return cuentaRepositorio.save(c);
    }
    
    
}
