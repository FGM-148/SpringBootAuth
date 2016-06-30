package com.example.bootauth.service;


import com.example.bootauth.model.Account;
import com.example.bootauth.repository.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public Account createAccount(Account account, String password) {

        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
        account.setHashed_password(hashed_password);
        accountRepository.save(account);

        return account;
    }

}
