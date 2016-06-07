package com.epam.application.dao;

import com.epam.application.bean.Account;
import com.epam.application.dao.exception.DaoException;

public interface AccountDAO extends Dao {

    public void addAccount(Account account) throws DaoException;

    public Account getAccount(String login) throws DaoException;
}
