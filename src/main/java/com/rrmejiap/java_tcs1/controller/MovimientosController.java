package com.rrmejiap.java_tcs1.controller;

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

import com.rrmejiap.java_tcs1.model.Movimientos;
import com.rrmejiap.java_tcs1.services.MovimientosService;

@RestController
@RequestMapping("/api/v1/Movimientos")
public class MovimientosController {
	@Autowired
	private MovimientosService movimientosService;

	@GetMapping()
	public List<Movimientos> getMovimientos() {
		return movimientosService.getMovimientos();
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Movimientos movimientos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movimientosService.saveContry(movimientos));
	}

	@DeleteMapping("/{Movimientosid}")
	private void deleteCountry(@PathVariable("Movimientosid") int id) {
		movimientosService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movimientos> updateTutorial(@PathVariable("id") Integer id, @RequestBody Movimientos movimientos) {
		Optional<Movimientos> tutorialData = movimientosService.findById(id);
		if (tutorialData.isPresent()) {
			Movimientos movimientosIni = tutorialData.get();
			movimientosIni.setTipoMovimiento(movimientos.getTipoMovimiento());
			movimientosIni.setDescripcionMovimiento(movimientos.getDescripcionMovimiento());
			movimientosIni.setMontoMovimiento(movimientos.getMontoMovimiento());
			movimientosIni.setNumeroMovimiento(movimientos.getNumeroMovimiento());
			movimientosIni.setFechaMovimiento(movimientos.getFechaMovimiento());
			movimientosIni.setUsuarioMovimiento(movimientos.getUsuarioMovimiento());
			return new ResponseEntity<>(movimientosService.saveContry(movimientosIni), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}	

}
