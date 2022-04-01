package com.pichincha.cuenta.java_tcs.controller;

import com.pichincha.cuenta.java_tcs.entity.Account;
import com.pichincha.cuenta.java_tcs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/saveAccount",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account saveAccount(@RequestBody(required = false) Account account) throws Exception {
        return accountService.save(account);
    }

    @RequestMapping(value = "/findAllAccount", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> findAllAccount(){
        return accountService.findAccountList();
    }


}
