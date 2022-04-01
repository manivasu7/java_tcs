package com.chapterbackendbp.movimientos.servicio.Impl;

import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Movimiento;
import com.chapterbackendbp.movimientos.repositorio.movimineto.MovimientoRepositorio;
import com.chapterbackendbp.movimientos.servicio.MovimientoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoServicioImpl implements MovimientoServicio {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    @Override
    public Optional<Movimiento> siExists(long id) {
        return Optional.ofNullable(movimientoRepositorio.getById(id));
    }

    @Override
    public void eliminarMovimiento(long id) {
        movimientoRepositorio.deleteById(id);
    }


    
}
