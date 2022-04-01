package com.chapterbackendbp.movimientos.controlador.MovimientoControlador;

import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Movimiento;
import com.chapterbackendbp.movimientos.servicio.MovimientoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimientos")
public class MovimientoControlador {
    
    @Autowired
    private MovimientoServicio movimientoServicio;

    MovimientoControlador(MovimientoServicio movimientoServicio){
        this.movimientoServicio = movimientoServicio;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> movimientos(@PathVariable Long id){
        Optional<Movimiento> sinomoviemiento = movimientoServicio.siExists(id);
        if(sinomoviemiento.isPresent()){
            movimientoServicio.eliminarMovimiento(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
