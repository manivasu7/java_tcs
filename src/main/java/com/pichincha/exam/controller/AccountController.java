package com.pichincha.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.exam.dto.AccountDto;
import com.pichincha.exam.service.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<?> createAcount(@RequestBody AccountDto account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
	}
	
	@PutMapping("/{accountId}")
	public ResponseEntity<?> updateAcount(@RequestBody AccountDto account,@PathVariable(name = "accountId") Long accountId) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.updateAccount(account,accountId));
	}
}
