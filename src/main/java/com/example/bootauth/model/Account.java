package com.example.bootauth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountId", updatable = false, nullable = false)
    private Long accountId;

    @Column(name = "login")
    private String login;

    @Column(name = "uuid")
    private String uuid;

    @JsonIgnore
    @Column(name = "hashed_password")
    private String hashedPassword;

    public Account(String login) {
        this.login = login;
    }

    public Account(){}

    public Long getId() {
        return accountId;
    }

    public void setId(Long id) {
        accountId = id;
    }

    public String getLogin() {
        return login;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
}
