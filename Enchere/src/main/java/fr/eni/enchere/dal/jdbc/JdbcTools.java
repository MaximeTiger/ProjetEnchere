package fr.eni.enchere.dal.jdbc;

import fr.eni.enchere.dal.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

    private static String urldb;
    private static String userdb;
    private static String passworddb;

    static {
        urldb = Settings.getProperty("jdbc:sqlserver://localhost:1433;databasename=ENCHERE");
        userdb = Settings.getProperty("sa");
        passworddb = Settings.getProperty("Pa$$w0rd");

        System.out.println("urldb = " + urldb);
        System.out.println("userdb = " + userdb);
        System.out.println("passworddb = " + passworddb);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urldb,userdb,passworddb);
    }

}
