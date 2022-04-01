package com.chapterbackendbp.movimientos.controlador.CuentaControlador;

import java.util.List;
import java.util.Optional;

import com.chapterbackendbp.movimientos.entidades.Cuenta;
import com.chapterbackendbp.movimientos.servicio.CuentaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/cuentas")
public class CuentaControlador {

    @Autowired
    private CuentaServicio CuentaServicio;

    CuentaControlador(CuentaServicio CuentaServicio){
        this.CuentaServicio = CuentaServicio;
    }

    @GetMapping()
    public ResponseEntity<List<Cuenta>> cuentas(){
        return new ResponseEntity<List<Cuenta>>(CuentaServicio.cuentas(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> cuentas(@RequestBody Cuenta nuevoCuenta, @PathVariable Long id){
        Optional<Cuenta> sinocuenta = CuentaServicio.buscarPorId(id);
        if(sinocuenta.isPresent()){
            Cuenta cuentaParaActualizar = sinocuenta.get();
            cuentaParaActualizar.setFechaunirse(nuevoCuenta.getFechaunirse());
            cuentaParaActualizar.setNombrededliente(nuevoCuenta.getNombrededliente());
            cuentaParaActualizar.setNumerodecuenta(nuevoCuenta.getNumerodecuenta());

            Cuenta cuentaActualizado = CuentaServicio.guardarCuenta(cuentaParaActualizar);

            return new ResponseEntity<Cuenta>(cuentaActualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Cuenta> cuentas(@RequestBody Cuenta nuevoCuenta){
        Cuenta cuentaNuevo = CuentaServicio.guardarCuenta(nuevoCuenta);
        return new ResponseEntity<Cuenta>(cuentaNuevo, HttpStatus.CREATED);
    }

}
