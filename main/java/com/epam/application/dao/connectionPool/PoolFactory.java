package com.epam.application.dao.connectionPool;


import com.epam.application.dao.connectionPool.impl.DbConnectionPool;

import java.util.HashMap;
import java.util.Map;

public class PoolFactory {

    private static PoolFactory poolFactory = new PoolFactory();
    private Map<PoolType,ConnectionPool> pools;

    private PoolFactory() {

        pools = new HashMap<PoolType, ConnectionPool>(1);
        pools.put(PoolType.DB_POOL, new DbConnectionPool());
    }

    public static PoolFactory getPoolFactory() {

        return poolFactory;
    }

    public ConnectionPool getPool(PoolType poolType) {

         return pools.get(poolType);
    }

    public static enum PoolType{DB_POOL}

}
