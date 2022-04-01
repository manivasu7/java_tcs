package com.bankaccount.account.controller;

import com.bankaccount.account.dto.BankAccountMovementsDto;
import com.bankaccount.account.exception.NoResourceException;
import com.bankaccount.account.service.BankAccountMovementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RestController()
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class BankAccountMovementsController {
    @Autowired
    BankAccountMovementsService bankAccountMovementsService;

    @Produces("application/json")
    @GetMapping(value = "/public/getAllBankAccountMovements")
    public ResponseEntity<List> getAllBankAccountMovements() {
        return new ResponseEntity<List>(bankAccountMovementsService.getAllBankAccountMovements(), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/public/saveBankAccountMovements")
    public ResponseEntity save(@RequestBody BankAccountMovementsDto bankAccountMovementsDto) {
        return new ResponseEntity(bankAccountMovementsService.createBankAccountMovement(bankAccountMovementsDto), HttpStatus.OK);
    }

    @Produces("application/json")
    @PutMapping(value = "/public/updateBankAccountMovements/{id}")
    public ResponseEntity update(@PathVariable(value = "id") Long id, @RequestBody BankAccountMovementsDto bankAccountMovementsDto) {
        try {
            return new ResponseEntity(bankAccountMovementsService.updateBankAccountMovement(id, bankAccountMovementsDto), HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/public/deleteBankAccountMovements/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        try {
            bankAccountMovementsService.deleteBankAccountMovement(id);
            return new ResponseEntity("Se elimino la entidad", HttpStatus.OK);
        } catch (NoResourceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}