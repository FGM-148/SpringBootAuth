package com.example.bootauth.dto;

public class AccountDTO {

    private String login;
    private String password;

    public AccountDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AccountDTO(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
