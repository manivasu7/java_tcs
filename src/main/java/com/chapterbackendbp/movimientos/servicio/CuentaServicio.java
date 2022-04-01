package com.chapterbackendbp.movimientos.servicio;

import java.util.List;
import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Cuenta;

public interface CuentaServicio {
    
    public List<Cuenta> cuentas();
    public Optional<Cuenta> buscarPorId(long id);
    public Cuenta guardarCuenta(Cuenta c);
}
