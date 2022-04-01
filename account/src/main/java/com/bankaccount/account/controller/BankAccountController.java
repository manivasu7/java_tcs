package com.bankaccount.account.controller;

import com.bankaccount.account.dto.BankAccountDto;
import com.bankaccount.account.exception.NoResourceException;
import com.bankaccount.account.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RestController()
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;

    @Produces("application/json")
    @GetMapping(value = "/public/getAllBankAccount")
    public ResponseEntity<List> getAllBankAccount() {
        return new ResponseEntity<List>(bankAccountService.getAllBankAccount(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/public/save")
    public ResponseEntity save(@RequestBody BankAccountDto bankAccountDto) {
        return new ResponseEntity(bankAccountService.createBankAccount(bankAccountDto), HttpStatus.OK);
    }

    @Produces("application/json")
    @PutMapping(value = "/public/update/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody BankAccountDto bankAccountDto) {
        try {
            return new ResponseEntity(bankAccountService.updateBankAccount(id, bankAccountDto), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/public/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        try {
            bankAccountService.deleteBankAccount(id);
            return new ResponseEntity("Se elimino la entidad", HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}