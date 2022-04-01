package com.evaluacion.ejemplotcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.ejemplotcs.model.Cuenta;
import com.evaluacion.ejemplotcs.services.CuentaService;

//mark class as Controller  
@RestController  
public class Base {
	//autowire the BooksService class  
	@Autowired  
	CuentaService cuentaService;  
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/cuenta")  
	private List<Cuenta> getAllCuenta()   
	{  
	return cuentaService.getAllCuenta();  
	}  
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/cuenta/{id}")  
	private Cuenta getCuenta(@PathVariable("id") int id)   
	{  
	return cuentaService.getCuentaById(id);  
	}  
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/cuenta/{id}")  
	private void deleteCuenta(@PathVariable("id") int id)   
	{  
	cuentaService.delete(id);  
	}  
	//creating post mapping that post the book detail in the database  
	@PostMapping("/cuenta")  
	private int saveCuenta(@RequestBody Cuenta cuenta)   
	{  
	cuentaService.saveOrUpdate(cuenta);  
	return cuenta.getId();  
	}  
	//creating put mapping that updates the book detail   
	@PutMapping("/cuenta")  
	private Cuenta update(@RequestBody Cuenta cuenta)   
	{  
	cuentaService.saveOrUpdate(cuenta);  
	return cuenta;  
	}  
}
