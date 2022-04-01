package com.chapterbackendbp.movimientos.repositorio.movimineto;

import com.chapterbackendbp.movimientos.entidades.Movimiento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long>{
    
}
