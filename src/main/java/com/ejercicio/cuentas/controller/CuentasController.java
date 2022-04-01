package com.ejercicio.cuentas.controller;

import java.util.List;

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

import com.ejercicio.cuentas.dto.CuentasDto;
import com.ejercicio.cuentas.exception.ResourceNotFoundException;
import com.ejercicio.cuentas.services.CuentasService;

@RestController
@RequestMapping("/api/v1/cuenta")
public class CuentasController {
	@Autowired
	private CuentasService cuentasService;
	
	@GetMapping()
	public List<CuentasDto> getCuentas() {
		return cuentasService.getCuentas();
	}
	
	@PostMapping()
	public ResponseEntity<?> postCuentas(@RequestBody CuentasDto cuenta) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentasService.saveCuentas(cuenta));
	}
	
	
	@DeleteMapping("/{cuentaid}")
	private ResponseEntity<?> deleteCountry(@PathVariable("cuentaid") int id) {

		try {
			cuentasService.deleteCuentas(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<CuentasDto> updateTutorial(@PathVariable("id") Integer id, @RequestBody CuentasDto cuenta) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(cuentasService.update(cuenta, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
