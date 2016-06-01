package com.epam.application.dao.connectionPool;


import com.epam.application.dao.connectionPool.exception.PropertyNotSetException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PoolProperties {

    private static String driver;
    private static String url;
    private static String login;
    private static String password;
    private static Integer poolSize;

    public void setProperties(File configFile) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream(configFile));
        driver = properties.getProperty("db.driver");
        url = properties.getProperty("db.url");
        login = properties.getProperty("db.login");
        password = properties.getProperty("db.password");
        poolSize = Integer.valueOf(properties.getProperty("db.poolSize"));
    }

    public String getDriver() throws PropertyNotSetException {

        if (driver != null) {

            return driver;
        }
        else {

            throw new PropertyNotSetException("property driver is not set");
        }
    }

    public String getUrl() throws PropertyNotSetException {

        if (url != null) {

            return url;
        }
        else {

            throw new PropertyNotSetException("property url is not set");
        }
    }

    public String getLogin() throws PropertyNotSetException {

        if (login != null) {

            return login;
        }
        else {

            throw new PropertyNotSetException("property login is not set");
        }
    }

    public String getPassword() throws PropertyNotSetException {

        if (password != null) {

            return password;
        }
        else {

            throw new PropertyNotSetException("property password is not set");
        }
    }

    public int getPoolSize() throws PropertyNotSetException {

        if (poolSize != null) {

            return poolSize;
        }
        else {

            throw new PropertyNotSetException("property poolSize is not set");
        }
    }
}
