package com.ejercicio.contabilidad.service;

import com.ejercicio.contabilidad.dto.AccountDto;
import com.ejercicio.contabilidad.exception.AccountException;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public List<AccountDto> getAccounts();

    public AccountDto saveAccount(AccountDto account);

    public AccountDto updateAccount(AccountDto account, int id_account) throws AccountException;

    public void deleteAccount(int id) throws AccountException;

    public Optional<AccountDto> findAccount(Integer id_account);

}
