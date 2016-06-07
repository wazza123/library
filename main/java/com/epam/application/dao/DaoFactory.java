package com.epam.application.dao;


import java.util.HashMap;
import java.util.Map;

public class DaoFactory {

    private static DaoFactory daoFactory = new DaoFactory();
    private Map<DaoType,Dao> daoType;

    private DaoFactory() {

        daoType = new HashMap<DaoType, Dao>(2);
        daoType.put(DaoType.DB_ACCOUNT_DAO, new DbAccountDao());
        daoType.put(DaoType.DB_BOOk_DAO, new DbBookDao());
    }

    public static DaoFactory getDaoFactory() {

        return daoFactory;
    }

    public Dao getDao(DaoType dao) {

        return daoType.get(dao);
    }

    public enum DaoType {DB_ACCOUNT_DAO, DB_BOOk_DAO}
}
