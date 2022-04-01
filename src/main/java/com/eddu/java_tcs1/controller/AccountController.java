package com.eddu.java_tcs1.controller;

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

import com.eddu.java_tcs1.model.Account;
import com.eddu.java_tcs1.services.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("getAccounts")
	private List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("getAccount/{accountid}")
	private Account getAccount(@PathVariable("accountid") Integer accountid){
		return accountService.getAccountId(accountid);
	}
	
	@DeleteMapping("deleteAccount/{accountid}")
	private void deleteAccount(@PathVariable("accountid") Integer accountid){
		accountService.deleteAccount(accountid);
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<?> postCountrie(@RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(accountService.saveOrUpdateAccount(account));

	}
	
	@PutMapping("/updateAccount/{accountid}")
	private Account updateAccount(@PathVariable("accountid") Integer accountid,Account account){   
	  
		accountService.updateAccount(account, accountid);
	   return account;  
	} 
	
	
	
	
	
}
