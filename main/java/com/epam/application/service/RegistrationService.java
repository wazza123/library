package com.epam.application.service;


import com.epam.application.bean.Account;
import com.epam.application.dao.AccountDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class RegistrationService implements Service {

    public Object execute(Object... params) throws ServiceException {

        String login = (String) params[0];
        String password = (String) params[1];
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        AccountDAO accountDAO = (AccountDAO) daoFactory.getDao(DaoFactory.DaoType.DB_ACCOUNT_DAO);
        Account account = new Account();

        account.setLogin(login);
        account.setPassword(password);

        try {

            if (accountDAO.getAccount(login) == null) {

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
