package com.mayank.examproj.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mayank.examproj.dto.CuentaDto;
import com.mayank.examproj.dto.MovementDto;
import com.mayank.examproj.exception.NoResourceException;
import com.mayank.examproj.service.CuentaService;
import com.mayank.examproj.service.MovementService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class Controller {
	@Autowired
	private CuentaService cuentaService;
	@Autowired
	private MovementService movementService;

	@GetMapping
	@Produces("application/json")
	public ResponseEntity<List> getAllCuentas() {
		return new ResponseEntity<List>(cuentaService.getAllCuentas(), HttpStatus.OK);
	}

	@GetMapping("/movement/{cuenta}")
	@Produces("application/json")
	public ResponseEntity<List> getMovements(@PathVariable(value = "cuenta") long cuenta) {
		return new ResponseEntity<List>(movementService.getMovementsPorCuenta(cuenta), HttpStatus.OK);
	}

	@PostMapping(path = "/cuenta", consumes = "application/json")
	@ResponseBody
	public ResponseEntity save(@RequestBody CuentaDto clientDto) {
		return new ResponseEntity(cuentaService.createCuenta(clientDto), HttpStatus.OK);
	}

	@PostMapping(path = "/movement", consumes = "application/json")
	@ResponseBody
	public ResponseEntity save(@RequestBody MovementDto movementDto) {
		return new ResponseEntity(movementService.createMovement(movementDto), HttpStatus.OK);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@Produces("application/json")
	public ResponseEntity update(@PathVariable(value = "id") Long personId, @RequestBody CuentaDto cuentaDto) {
		try {
			return new ResponseEntity(cuentaService.updateCuenta(personId, cuentaDto), HttpStatus.OK);
		} catch (NoResourceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{movementID}")
	public ResponseEntity deleteMovement(@PathVariable(value = "movementID") Long movementID) {
		try {
			movementService.deleteMovement(movementID);
			return new ResponseEntity("Se elimino la entidad", HttpStatus.OK);
		} catch (NoResourceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
