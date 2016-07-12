package com.example.bootauth.service;


import com.example.bootauth.model.Account;
import com.example.bootauth.repository.AccountRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.UUID;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account, String password) {

        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
        account.setHashedPassword(hashed_password);
        accountRepository.save(account);

        return account;
    }

    public String getNewAccessToken(String login, String password) throws InvalidKeyException {

        Account account = accountRepository.findByLogin(login);

        if (account == null)
            throw new InvalidKeyException("Invalid Login");

        if (!comparePassword(password,account.getHashedPassword()))
            throw new InvalidKeyException("Invalid Password");

        String uuid = UUID.randomUUID().toString();
        account.setUuid(uuid);
        accountRepository.save(account);

        return uuid;
    }

    private boolean comparePassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword,hashedPassword);
    }
}
