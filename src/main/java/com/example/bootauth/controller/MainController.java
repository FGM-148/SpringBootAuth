package com.example.bootauth.controller;


import com.example.bootauth.dto.AccountDTO;
import com.example.bootauth.model.Account;
import com.example.bootauth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;


@RestController
public class MainController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "createAccount", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {

        String password = accountDTO.getPassword();
        Account account =  new Account(accountDTO.getLogin());
        accountService.createAccount(account, password);

        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody AccountDTO accountDTO) {

        String password = accountDTO.getPassword();
        String login = accountDTO.getLogin();
        String uuid = null;
        HttpStatus httpStatus;
        try {
            uuid = accountService.getNewAccessToken(login, password);
            httpStatus = HttpStatus.OK;
        } catch (InvalidKeyException e) {
            httpStatus = HttpStatus.UNAUTHORIZED;
        }

        return new ResponseEntity<String>(uuid, httpStatus);
    }
}
