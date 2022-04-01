/**
 * 
 */
package com.pichincha.customer.movements.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.customer.movements.entity.AccountEntity;
import com.pichincha.customer.movements.service.AccountService;


/**
 * @author jjoseph
 *
 */
@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/getAllAccountDetails")
	public ResponseEntity<List<AccountEntity>> getAllAccountDetails() {
		try {
			List<AccountEntity> account = new ArrayList<AccountEntity>();
			account = accountService.getAllAccounts();
				
			if (account.isEmpty()) {
				return new ResponseEntity<List<AccountEntity>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<AccountEntity>>(account, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
