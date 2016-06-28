package com.example.bootauth.model;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", updatable = false, nullable = false)
    private Long account_id;

    @Column(name = "login")
    private String login;

    @Column(name = "hashed_password")
    private String hashed_password;

    public Long getId() {
        return account_id;
    }

    public void setId(Long id) {
        account_id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
