package com.pichincha.tcsbank.controller;

import com.pichincha.tcsbank.model.Account;
import com.pichincha.tcsbank.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> saveAcount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity updateAccount(@PathVariable(value = "id") Long id,@RequestBody Account account){
        Account accountResp = accountService.updateAccount(id,account);
        if(accountResp == null) return new ResponseEntity("The entity not Exists",HttpStatus.NOT_FOUND);

        return new ResponseEntity(accountResp,HttpStatus.OK);
    }
}
