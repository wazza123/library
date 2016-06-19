package com.epam.application.service;


import com.epam.application.bean.Account;
import com.epam.application.dao.AccountDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class AuthorizationService implements Service {

    final Logger LOGGER = Logger.getRootLogger();

    public Object execute(Object... params) throws ServiceException {

        String login = (String) params[0];
        String password = (String) params[1];
        String passwordHash = StringEncoder.encodeString(password);

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        AccountDAO accountDAO = (AccountDAO) daoFactory.getDao(DaoFactory.DaoType.DB_ACCOUNT_DAO);
        Account account;

        try {

            account = accountDAO.getAccount(login);

        } catch (DaoException e) {

            LOGGER.error("command layer exception",e);
            throw new ServiceException(e);
        }

        if (account == null) {

            return null;
        }
        else if (account.getLogin().equals(login) && account.getPassword().equals(passwordHash)) {

            return account;
        }
        else {

            return null;
        }
    }
}
