package com.company.library.dao;


import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

    private static DaoFactory daoFactory = new DaoFactory();
    private Map<DaoType,Dao> daoType;

    private DaoFactory() {

        daoType = new HashMap<DaoType, Dao>();
        daoType.put(DaoType.DB_ACCOUNT_DAO, new DbAccountDao());
        daoType.put(DaoType.DB_BOOK_DAO, new DbBookDao());
        daoType.put(DaoType.DB_WRITER_DAO, new DbWriterDao());
    }

    public static DaoFactory getDaoFactory() {

        return daoFactory;
    }

    public Dao getDao(DaoType dao) {

        return daoType.get(dao);
    }

    public enum DaoType {DB_ACCOUNT_DAO, DB_BOOK_DAO,DB_WRITER_DAO}
}
