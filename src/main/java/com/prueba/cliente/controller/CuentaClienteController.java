package com.prueba.cliente.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.CuentasDeClientes;
import com.prueba.cliente.service.ICuentaClienteService;



@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = "*")
public class CuentaClienteController {
	
    @Autowired
    private ICuentaClienteService cuentaClienteService;
    
    //@GetMapping
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
    //@Produces("application/json")
    public ResponseEntity<List> getAllCuentas() {
        return new ResponseEntity<List>(cuentaClienteService.getAllCuentas(), HttpStatus.OK);
    }
    
    @PostMapping
    @ResponseBody
    public ResponseEntity saveCuenta(@RequestBody CuentasDeClientes cuenta) {
        return new ResponseEntity(cuentaClienteService.createCuenta(cuenta), HttpStatus.OK);
    }
    
    
    //@PutMapping("/{id}")
    //@Produces("application/json")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/json" })
    public ResponseEntity updateCuenta(@PathVariable(value = "id") Long cuentaId, @RequestBody CuentasDeClientes cuenta) {
        try {
            return new ResponseEntity(cuentaClienteService.updateCuenta(cuentaId, cuenta), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCuenta(@PathVariable(value = "id") Long cuentaId) {
        try {
        	cuentaClienteService.deleteCuenta(cuentaId);
            return new ResponseEntity("Se elimino la cuenta",HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
