
package com.tabeldata.configs;



import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author ADIB PC
 */
public class DatabaseKonfigurasi {
    private String url ="jdbc:postgresql://localhost:5432/latihan_1";
    private String username = "postgres";
    private String password = "obed123zr";
 
    public DataSource getDatasource() throws SQLException{
    BasicDataSource dbcp = new BasicDataSource();
    dbcp.setUrl(url);
    dbcp.setPassword(password);
    dbcp.setUsername(username);
    return dbcp;
}
    
    public static void main(String[] args) throws SQLException {
            DatabaseKonfigurasi koneksi = new DatabaseKonfigurasi();
            Connection connection = koneksi.getDatasource().getConnection();
            connection.close();
            System.out.println("Database Bekerja");
        
        
    }
}
