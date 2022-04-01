package com.ejercicio.contabilidad.service.impl;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.exception.AccountException;
import com.ejercicio.contabilidad.model.Accounts;
import com.ejercicio.contabilidad.repository.AccountRepo;
import com.ejercicio.contabilidad.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public List<AccountDto> getAccounts() {

        List<Accounts> account =accountRepo.findAll();

        return account.stream().map(c -> c.ToDto()).collect(Collectors.toList());

    }

    public AccountDto saveAccount(AccountDto account) {

        return accountRepo.save(account.toEntity()).ToDto();
    }

    public AccountDto updateAccount(AccountDto account, int id) throws AccountException {
        Optional<AccountDto> tutorialData = findAccount(id);
        if (tutorialData.isPresent()) {
            Accounts objAccount = tutorialData.get().toEntity();
            objAccount.setName_account(account.getName_account());
            objAccount.setCode_account(account.getCode_account());
            return accountRepo.save(objAccount).ToDto();
        } else {
            throw new AccountException("Cuenta no existe");
        }

    }

    public void deleteAccount(int id) throws AccountException {
        Optional<AccountDto> tutorialData = findAccount(id);
        if (tutorialData.isPresent()) {
            accountRepo.deleteById(id);
        } else {
            throw new AccountException("Cuenta no existe");
        }
    }

    public Optional<AccountDto> findAccount(Integer id) {

        Optional<Accounts>  objAccount = accountRepo.findById(id);
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
