package com.ejercicio.accounts.demoaccounts.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.accounts.demoaccounts.dto.AccountDto;
import com.ejercicio.accounts.demoaccounts.exception.NotFoundResourceException;
import com.ejercicio.accounts.demoaccounts.service.AccountService;
import com.ejercicio.accounts.demoaccounts.service.MovementService;

@RestController
@RequestMapping(value = "/account")
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private MovementService movementService;

	@PostMapping("/addAccount")
	@ResponseBody
	public ResponseEntity save(@RequestBody AccountDto accountDto) {
		return new ResponseEntity(accountService.createAccount(accountDto), HttpStatus.OK);
	}

	@PutMapping("updateAccount/{id}")
	@Produces("application/json")
	public ResponseEntity update(@PathVariable(value = "id") Long clientId, @RequestBody AccountDto accountDto) {
		try {
			return new ResponseEntity(accountService.updateAccount(clientId, accountDto), HttpStatus.OK);
		} catch (NotFoundResourceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("deleteMovement/{id}")
	public ResponseEntity deleteOrder(@PathVariable(value = "id") Long id) {
		try {
			movementService.deleteMovement(id);
			return new ResponseEntity("El movimiento ha sido eliminado", HttpStatus.OK);
		} catch (NotFoundResourceException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findMovement/{id}")
	@Produces("application/json")
	public ResponseEntity<List> getAllAccount(@PathVariable(value = "id") Long id) {
		try {
			return new ResponseEntity(accountService.getAllMovement(id), HttpStatus.OK);
		} catch (NotFoundResourceException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			// throw new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
