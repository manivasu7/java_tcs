package com.pichincha.service.controller;

import java.util.List;

import com.pichincha.service.dto.AccountDto;
import com.pichincha.service.exception.ExceptionService;
import com.pichincha.service.service.ServiceInterfaz;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final ServiceInterfaz serviceInterfaz;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllProducts(){
        try {
            return new ResponseEntity<>(serviceInterfaz.getProducts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<AccountDto> saveProduct(@RequestBody AccountDto accountDto){
        try {
            return new ResponseEntity<>(serviceInterfaz.saveAccount(accountDto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id , @RequestBody AccountDto accountDto ){
        try {
            return new ResponseEntity<>(serviceInterfaz.updateAccount(id,accountDto), HttpStatus.OK);
        } catch (ExceptionService e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id){

        Boolean response = serviceInterfaz.deleteAccount(id);

        if (!response)
            return new ResponseEntity<>("The product is does not exist", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
