package com.tabeldata.configs;

import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class KonfigDB {

    private final static String url = "jdbc:postgresql://localhost:5432/latihan_1";
    private final static String username = "postgres";
    private final static String password = "obed123zr";

    public static DataSource getDatasource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;

    }
    public static void main(String[] args) throws SQLException {
        KonfigDB.getDatasource().getConnection();
    }

}
