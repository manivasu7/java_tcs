package com.cgranada.java_tcs1.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgranada.java_tcs1.dto.AccountDto;
import com.cgranada.java_tcs1.exception.ResourceNotFoundException;
import com.cgranada.java_tcs1.model.Account;
import com.cgranada.java_tcs1.repository.AccountRepo;
import com.cgranada.java_tcs1.service.AccountService;

@Service
public class AccountServiceImp implements AccountService{
/* @Autowired
 private AccountRepo accoutnRepo;
 
 public List<AccountDto> getAccount() {
		
		List<Account> objAccount =accoutnRepo.findAll();
		
		return objAccount.stream().map(c -> c.ToDto()).collect(Collectors.toList());
	
				
	}
 
 public AccountDto saveAccount(AccountDto account) {

		return accoutnRepo.save(account.toEntity()).ToDto();
	}
 
 public AccountDto updateAccount (AccountDto account, Integer id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData =findAccount(id);
				
		if (tutorialData.isPresent()) {
			Account objAccount = tutorialData.get().toEntity();
			objAccount.setAccountNumber(account.getAccountNumber());
			objAccount.setAcoountOwner(account.getAcoountOwner());
						
			return accoutnRepo.save(objAccount).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}
 
 public void deleteAccount(Integer id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData = findAccount(id);
		if (tutorialData.isPresent()) {
			accoutnRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

 public Optional<AccountDto> findCountry(Integer id) {
		
		Optional<Account>  objAccount = accoutnRepo.findById(id);
		Optional<AccountDto> objAccountDto;
		if(objAccount.isPresent()) {
			
			objAccountDto =  Optional.of(objAccount.get().ToDto());
		}
		else {
			objAccountDto = Optional.empty();
		}	
		return objAccountDto;
	}
 */
}
