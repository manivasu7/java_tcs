package com.pichincha.backend.practica.controller;

import com.pichincha.backend.practica.dto.AcountDto;
import com.pichincha.backend.practica.model.Acount;
import com.pichincha.backend.practica.service.AcountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acount")
public class AcountController {
    private final AcountService acountService;

    public AcountController(AcountService acountService) {
        this.acountService = acountService;
    }

    @PostMapping
    public ResponseEntity<AcountDto> saveAcount(@RequestBody AcountDto acount){
        try {
        return new ResponseEntity<>(acountService.saveAcount(acount), HttpStatus.OK);
        } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="{id}")
    public ResponseEntity<AcountDto> updateAcount(@PathVariable Long id , @RequestBody AcountDto acountDto ){
            return new ResponseEntity<>(acountService.updateAcount(id,acountDto), HttpStatus.OK);
    }


}
