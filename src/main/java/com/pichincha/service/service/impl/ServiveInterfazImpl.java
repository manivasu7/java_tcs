package com.pichincha.service.service.impl;

import com.pichincha.service.dto.AccountDto;
import com.pichincha.service.exception.ExceptionService;
import com.pichincha.service.model.Account;
import com.pichincha.service.repository.AccountRepository;
import com.pichincha.service.service.ServiceInterfaz;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiveInterfazImpl implements ServiceInterfaz {

    private final AccountRepository accountRepository;

    @Autowired
    public ServiveInterfazImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getProducts() {

        ArrayList<AccountDto> accountDto = new ArrayList<AccountDto>();

        accountRepository.findAll()
                .forEach(product -> {
                    accountDto.add(product.getAsDto());
                });

        return accountDto;
   }

    @Override
    public AccountDto saveAccount(AccountDto accountDto) {
        return accountRepository.save(accountDto.getAsEntity()).getAsDto();
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) throws ExceptionService {

        Account accountBdd = accountRepository.findById(id).orElse(null);

        if (accountBdd == null )
            throw new ExceptionService("No exists");

        accountBdd.setNumber( accountDto.getNumber() );
        accountBdd.setType( accountDto.getType());
        accountBdd.setName( accountDto.getName());
        accountBdd.setLastName( accountDto.getLastName());
        accountBdd.setAmount( accountDto.getAmount());

        return accountRepository.save(accountBdd).getAsDto();
    }

    @Override
    public Boolean deleteAccount(Long id) {

        Account accountBdd = accountRepository.findById(id).orElse(null);

        if ( accountBdd == null )
            return false;

        accountRepository.deleteById(id);
        return true;
    }

}
