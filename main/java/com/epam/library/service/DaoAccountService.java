package com.epam.library.service;

import com.epam.library.bean.Account;
import com.epam.library.dao.AccountDAO;
import com.epam.library.dao.DaoFactory;
import com.epam.library.dao.exception.DaoException;
import com.epam.library.service.exception.ServiceException;


public class DaoAccountService implements AccountService {

    public Account getAccount(String login) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        AccountDAO accountDAO = (AccountDAO) daoFactory.getDao(DaoFactory.DaoType.DB_ACCOUNT_DAO);

        try {

            return accountDAO.getAccount(login);
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }

    public boolean authorize(Account account) throws ServiceException {

        String login = account.getLogin();
        String passwordHash = StringEncoder.encodeString(account.getPassword());
        Account acc = null;

        acc = getAccount(login);

        if (acc == null) {

            return false;
        }
        else {

            return account.getLogin().equals(login) && account.getPassword().equals(passwordHash);
        }
    }

    public boolean registrate(Account account) throws ServiceException {

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        AccountDAO accountDAO = (AccountDAO) daoFactory.getDao(DaoFactory.DaoType.DB_ACCOUNT_DAO);
        Account acc = new Account();

        acc.setLogin(account.getLogin());
        account.setPassword( StringEncoder.encodeString(account.getPassword()) );

        try {

            if (accountDAO.getAccount(acc.getLogin()) == null) {

                accountDAO.addAccount(account);
                return true;
            }
            else {

                return false;
            }
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
