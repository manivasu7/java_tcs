package com.example.java_tcs.controller;

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

import com.example.java_tcs.dto.CuentasDto;
import com.example.java_tcs.exeption.ResourceNotFoundException;
import com.example.java_tcs.service.CuentasService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentasController {

	@Autowired
	private CuentasService cuentasService;

	@GetMapping()
	public List<CuentasDto> getCuentas() {
		return cuentasService.getCuentas();
	}

	@PostMapping()
	public ResponseEntity<?> postCuentas(@RequestBody CuentasDto cuentas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentasService.saveCuentas(cuentas));

	}

	@DeleteMapping("/{cuentasid}")
	private ResponseEntity<?> deleteCuentas(@PathVariable("cuentasid") int id) {

		try {
			cuentasService.deleteCuentas(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<CuentasDto> updateTutorial(@PathVariable("id") Integer id, @RequestBody CuentasDto cuentas) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(cuentasService.update(cuentas, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
