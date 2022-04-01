package com.pichincha.java_tcs_cpenriqu.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.java_tcs_cpenriqu.dto.AccountDto;
import com.pichincha.java_tcs_cpenriqu.exception.ResourceNotFoundException;
import com.pichincha.java_tcs_cpenriqu.model.Account;
import com.pichincha.java_tcs_cpenriqu.repository.AccountRepo;
import com.pichincha.java_tcs_cpenriqu.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	public List<AccountDto> getAccounts() {
		
		List<Account> objAccount =accountRepo.findAll();
		
		return objAccount.stream().map(c -> c.ToDto()).collect(Collectors.toList());
				
	}

	public AccountDto saveAccount(AccountDto account) {

		return accountRepo.save(account.toEntity()).ToDto();
	}

	public AccountDto update(AccountDto account, int id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData = findAccount(id);
		if (tutorialData.isPresent()) {
			Account objAccount = tutorialData.get().toEntity();
			objAccount.setName(account.getName());
			objAccount.setCode(account.getCode());
			return accountRepo.save(objAccount).ToDto();
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}

	}

	public void deleteAccount(int id) throws ResourceNotFoundException {
		Optional<AccountDto> tutorialData = findAccount(id);
		if (tutorialData.isPresent()) {
			accountRepo.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Id not exists");
		}
	}

	public Optional<AccountDto> findAccount(Integer id) {
		
		Optional<Account>  objAccount = accountRepo.findById(id);
		Optional<AccountDto> objAccountDto;
		if(objAccount.isPresent()) {
			
			objAccountDto =  Optional.of(objAccount.get().ToDto());
		}
		else {
			objAccountDto = Optional.empty();
		}	
		return objAccountDto;
	}
}
