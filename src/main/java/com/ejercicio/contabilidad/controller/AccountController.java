package com.ejercicio.contabilidad.controller;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.exception.AccountException;
import com.ejercicio.contabilidad.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping()
    public List<AccountDto> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping()
    public ResponseEntity<?> AddAccount(@RequestBody AccountDto account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(account));

    }

    @DeleteMapping("/{id_account}")
    private ResponseEntity<?> deleteAccount(@PathVariable("id_account") int id_account) {

        try {
            accountService.deleteAccount(id_account);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (AccountException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id_account") Integer id_account, @RequestBody AccountDto account) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(accountService.updateAccount(account, id_account));
        } catch (AccountException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
