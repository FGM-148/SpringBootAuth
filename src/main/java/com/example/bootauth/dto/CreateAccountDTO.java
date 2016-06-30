package com.example.bootauth.dto;

public class CreateAccountDTO {

    private String login;
    private String password;

    public CreateAccountDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CreateAccountDTO(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
