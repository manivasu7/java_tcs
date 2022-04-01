package com.bpichincha.java_tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bpichincha.java_tcs.model.Account;
import com.bpichincha.java_tcs.service.AccountService;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/account")
	public ResponseEntity getAllAccount() {
		return new ResponseEntity(accountService.getAccount(), HttpStatus.OK);
		
	}	
	
	@PostMapping("/account")
	public ResponseEntity addAccount(@RequestBody Account account) {
		return new ResponseEntity(accountService.addAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/account/{id}")
	public ResponseEntity getAccount(@PathVariable Long id) {
		return new ResponseEntity(accountService.getAccountId(id), HttpStatus.OK);
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return new ResponseEntity("Account deleted", HttpStatus.OK);
	}

	@PutMapping("/account/{id}")
	public ResponseEntity updateAccount(@RequestBody Account account, @PathVariable Long id) {
		return new ResponseEntity(accountService.updateAccount(account), HttpStatus.OK);
	}		

}
