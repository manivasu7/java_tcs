package com.ejercicio.cuentas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.cuentas.model.Movimientos;
import com.ejercicio.cuentas.services.MovimientosService;

@RestController
@RequestMapping("/api/v1/movimiento")
public class MovimientosController {
	@Autowired
	private MovimientosService movimientoService;
	
	@GetMapping()
	public List<Movimientos> getMovimientos() {
		return movimientoService.getMovimientos();
	}

	@PostMapping()
	public ResponseEntity<?> postMovimiento(@RequestBody Movimientos movimiento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movimientoService.save(movimiento));
	}
	
	@DeleteMapping("/{movimientoid}")
	private void deleteState(@PathVariable("movimientoid") int id)
	{
		movimientoService.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movimientos> updateTutorial(@PathVariable("id") Integer id, @RequestBody Movimientos movimiento) {
	 Optional<Movimientos> tutorialData = movimientoService.findById(id);
	 if (tutorialData.isPresent()) {
	  Movimientos _movimiento = tutorialData.get();
	  _movimiento.setFecha_movimiento(movimiento.getFecha_movimiento());
	  _movimiento.setTipo_movimiento(movimiento.getTipo_movimiento());
	  _movimiento.setValor_movimiento(movimiento.getValor_movimiento());
	  return new ResponseEntity<>(movimientoService.save(_movimiento), HttpStatus.OK);
	 } else {
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	}
	
}
