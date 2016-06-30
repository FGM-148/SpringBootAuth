package com.example.bootauth.controller;


import com.example.bootauth.model.Account;
import com.example.bootauth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        String password = "haslo";
        accountService.createAccount(account, password);

        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }

}
