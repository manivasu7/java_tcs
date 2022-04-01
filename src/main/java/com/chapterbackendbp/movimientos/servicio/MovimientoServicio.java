package com.chapterbackendbp.movimientos.servicio;

import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Movimiento;

public interface MovimientoServicio {
    
    public Optional<Movimiento> siExists(long id);
    public void eliminarMovimiento(long id);
}
