package com.epam.library.dao.pool;


import com.epam.library.dao.pool.impl.DbConnectionPool;

import java.util.HashMap;
import java.util.Map;

public class PoolFactory {

    private Map<PoolType,ConnectionPool> pools;

    private static class FactoryInstance {

        private static final PoolFactory instance = new PoolFactory();
    }

    private PoolFactory() {

        pools = new HashMap<PoolType, ConnectionPool>(1);
        pools.put(PoolType.DB_POOL, new DbConnectionPool());
    }

    public static PoolFactory getPoolFactory() {

        return FactoryInstance.instance;
    }

    public ConnectionPool getPool(PoolType poolType) {

         return pools.get(poolType);
    }

    public static enum PoolType{DB_POOL}
}
