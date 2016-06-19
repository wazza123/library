package com.epam.application.service;


import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class FindWriterService implements Service {

    public Object execute(Object... params) throws ServiceException {

        String firstName = (String) params[0];
        String lastName = (String) params[1];

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);

        try {

            return writerDao.getWritersByName(firstName, lastName);
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
