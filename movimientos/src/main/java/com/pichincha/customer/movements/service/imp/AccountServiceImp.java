/**
 * 
 */
package com.pichincha.customer.movements.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.customer.movements.entity.AccountEntity;
import com.pichincha.customer.movements.repository.AccountRepository;
import com.pichincha.customer.movements.service.AccountService;

/**
 * @author jjoseph
 *
 */
@Service
public class AccountServiceImp  implements AccountService{
	
	@Autowired
	AccountRepository  accountRepository;
	
	@Override
	public List<AccountEntity> getAllAccounts() {
		List<AccountEntity> accountEntities = (List<AccountEntity>) accountRepository.findAll();
		return accountEntities;
	}
}
