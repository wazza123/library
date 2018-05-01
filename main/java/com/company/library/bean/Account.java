package com.company.library.bean;


public class Account {

    private String login;
    private String password;
    private String role;

    public void setLogin(String login) {

        this.login = login;
    }

    public String getLogin() {

        return login;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {

        this.role = role;
    }
}
