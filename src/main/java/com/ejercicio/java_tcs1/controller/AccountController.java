package com.ejercicio.java_tcs1.controller;

import com.ejercicio.java_tcs1.dto.AccountDto;
import com.ejercicio.java_tcs1.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(accountDto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
