package com.prueba.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.cliente.exception.NoResourceException;
import com.prueba.cliente.model.MovimientoDeCuentasDeClientes;
import com.prueba.cliente.service.IMovimientosCuentasService;

@RestController
@RequestMapping("/movimiento")
@CrossOrigin(origins = "*")
public class MovimientosCuentasClientesController {

	@Autowired
    private IMovimientosCuentasService movimientoCuentaClienteService;

    //@GetMapping
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
    //@Produces("application/json")
    public ResponseEntity<List> getAllMovimientos() {
        return new ResponseEntity<List>(movimientoCuentaClienteService.getAllMovimientos(), HttpStatus.OK);
    }
    
    @PostMapping
    @ResponseBody
    public ResponseEntity saveCuenta(@RequestBody MovimientoDeCuentasDeClientes movimiento) {
        return new ResponseEntity(movimientoCuentaClienteService.createMovimiento(movimiento), HttpStatus.OK);
    }
    
    
    //@PutMapping("/{id}")
    //@Produces("application/json")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/json" })
    public ResponseEntity updateMovimiento(@PathVariable(value = "id") Long movimientoId, @RequestBody MovimientoDeCuentasDeClientes movimiento) {
        try {
            return new ResponseEntity(movimientoCuentaClienteService.updateMovimiento(movimientoId, movimiento), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovimiento(@PathVariable(value = "id") Long movimientoId) {
        try {
        	movimientoCuentaClienteService.deleteMovimiento(movimientoId);
            return new ResponseEntity("Se elimino el movimiento.",HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
