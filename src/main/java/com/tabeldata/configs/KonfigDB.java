package com.tabeldata.configs;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class KonfigDB {

    private final static String url = "jdbc:postgresql://localhost:5432/bootcamp_latihan";
    private final static String username = "bootcamp_latihan";
    private final static String password = "latihan";

    public static DataSource getDatasource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;

    }

}
