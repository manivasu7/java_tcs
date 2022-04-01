package com.chapterbackendbp.movimientos.controlador.HealthCheck;

import com.chapterbackendbp.movimientos.dto.HealthCheck.HealthCheckDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HealthCheck")
public class HealthCheckControlador {
    
    @GetMapping()
    public ResponseEntity<HealthCheckDto> getEstadoDeAplicacion(){
        HealthCheckDto tmp = new HealthCheckDto();
        tmp.setAplicacionActivo(true);

        return new ResponseEntity<HealthCheckDto>(tmp, HttpStatus.OK);
    }
}
