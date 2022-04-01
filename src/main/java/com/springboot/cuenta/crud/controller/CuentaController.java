package com.springboot.cuenta.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cuenta.crud.entity.Cuenta;
import com.springboot.cuenta.crud.service.CuentaService;


@RestController
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@PostMapping("/addCuenta")
	public Cuenta addCuenta(@RequestBody Cuenta cuenta)
	{
		return cuentaService.createCuenta(cuenta);
	}
	
	@PostMapping("/addCuentas")
	public List<Cuenta> addCuentas(@RequestBody List<Cuenta> cuentas)
	{
		return cuentaService.createCuentas(cuentas);
	}
	
	@GetMapping("/cuenta/{id}")
	public Cuenta getUser(@PathVariable int id)
	{
		return cuentaService.getCuenta(id);
	}

	@GetMapping("/cuentas")
	public List<Cuenta> getCuentas()
	{
		return cuentaService.getCuentas();
	}
	
	@PutMapping("/updateCuenta")
	public Cuenta updateCuenta(@RequestBody Cuenta cuenta)
	{
		return cuentaService.updateCuenta(cuenta);
	}
	
	@DeleteMapping("/cuenta/{id}")
	public String deleteCuenta(@PathVariable int id)
	{
		return cuentaService.deleteCuenta(id);
	}

}
