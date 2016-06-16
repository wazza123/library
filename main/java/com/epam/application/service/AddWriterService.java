package com.epam.application.service;


import com.epam.application.bean.Book;
import com.epam.application.bean.Writer;
import com.epam.application.dao.BookDAO;
import com.epam.application.dao.DaoFactory;
import com.epam.application.dao.WriterDao;
import com.epam.application.dao.exception.DaoException;
import com.epam.application.service.exception.ServiceException;

public class AddWriterService implements Service {

    public Object execute(Object... params) throws ServiceException {

        String firstName = (String) params[0];
        String lastName = (String) params[1];

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        WriterDao writerDao = (WriterDao) daoFactory.getDao(DaoFactory.DaoType.DB_WRITER_DAO);
        Writer writer = new Writer();
        writer.setFirstName(firstName);
        writer.setLastName(lastName);

        try {

            writerDao.addWriter(writer);
            return true;
        }
        catch (DaoException e) {

            throw new ServiceException(e);
        }
    }
}
