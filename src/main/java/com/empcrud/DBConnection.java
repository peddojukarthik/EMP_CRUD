package com.empcrud;

    import java.sql.*;
    import java.sql.Connection;
    import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/emp";
    private static final String USER = "root";
    private static final String PASSWORD = "Mextscholar@2007"; 

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
     
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

