package com.epam.application.bean;


public class Account {

    private String login;
    private String password;

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

    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + login.hashCode();
        result = prime * result + password.hashCode();
        return result;
    }

    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }
        if (obj == null) {

            return false;
        }
        if (getClass() != obj.getClass()) {

            return false;
        }

        Account other = (Account) obj;

        if (!login.equals(other.getLogin())) {

            return false;
        }
        if (!password.equals(other.getPassword())) {

            return false;
        }

        return true;
    }
}
