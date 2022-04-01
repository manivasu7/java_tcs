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

import com.rrmejiap.java_tcs1.model.Cuentas;
import com.rrmejiap.java_tcs1.services.CuentasService;

@RestController
@RequestMapping("/api/v1/Cuentas")
public class CuentasController {
	@Autowired
	private CuentasService cuentasService;

	@GetMapping()
	public List<Cuentas> getCuentas() {
		return cuentasService.getCuentas();
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody Cuentas cuentas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentasService.saveContry(cuentas));
	}

	@DeleteMapping("/{cuentasid}")
	private void deleteCountry(@PathVariable("cuentasid") int id) {
		cuentasService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cuentas> updateTutorial(@PathVariable("id") Integer id, @RequestBody Cuentas cuentas) {
		Optional<Cuentas> tutorialData = cuentasService.findById(id);
		if (tutorialData.isPresent()) {
			Cuentas cuentasIni = tutorialData.get();
			cuentasIni.setTipoCuenta(cuentas.getTipoCuenta());
			cuentasIni.setNumeroCuenta(cuentas.getNumeroCuenta());
			cuentasIni.setNombreCuenta(cuentas.getNombreCuenta());
			cuentasIni.setMontoCuenta(cuentas.getMontoCuenta());
			cuentasIni.setFechaCuenta(cuentas.getFechaCuenta());
			cuentasIni.setUsuarioCuenta(cuentas.getUsuarioCuenta());
			return new ResponseEntity<>(cuentasService.saveContry(cuentasIni), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	
}
