package com.pichincha.service.service;

import com.pichincha.service.dto.AccountDto;
import com.pichincha.service.exception.ExceptionService;
import com.pichincha.service.model.Movements;

import javax.security.auth.login.AccountException;
import javax.sql.rowset.serial.SerialException;
import java.security.Provider;
import java.util.List;

public interface ServiceInterfaz {

    List<AccountDto> getProducts();
    AccountDto saveAccount(AccountDto productDto);
    AccountDto updateAccount(Long id, AccountDto productDto) throws ExceptionService;
    Boolean deleteAccount(Long id);

}
