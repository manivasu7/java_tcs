package com.pichincha.cuenta.java_tcs.service;

import com.pichincha.cuenta.java_tcs.entity.Account;
import com.pichincha.cuenta.java_tcs.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository iAccountRepository;

    public AccountService() {
    }

    public AccountService(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    /**
     * Guarda una cuenta
     * @param Account
     * @return
     * @throws Exception
     */
    @Override
    public Account save(Account Account) throws Exception {
        return iAccountRepository.save(Account);
    }

    /**
     * Obtiene la lista de cuentas
     * @return
     */
    @Override
    public List<Account> findAccountList(){
        return (List<Account>) iAccountRepository.findAll();
    }

}

