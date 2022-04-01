package com.pichincha.java_tcs_cpenriqu.controller;

import java.util.List;

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

import com.pichincha.java_tcs_cpenriqu.dto.AccountDto;
import com.pichincha.java_tcs_cpenriqu.exception.ResourceNotFoundException;
import com.pichincha.java_tcs_cpenriqu.services.AccountService;

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
	public ResponseEntity<?> postAccount(@RequestBody AccountDto account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveAccount(account));

	}

	@DeleteMapping("/{accountid}")
	private ResponseEntity<?> deleteAccount(@PathVariable("accountid") int id) {

		try {
			accountService.deleteAccount(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> updateTutorial(@PathVariable("id") Integer id, @RequestBody AccountDto account) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(accountService.update(account, id));
		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}