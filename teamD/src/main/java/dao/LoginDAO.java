package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDAO {
    // データベース接続情報
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/medicines_management";
    private final String DB_USER = "root";
    private final String DB_PASS = "adminadmin";

    // データベース接続取得メソッド
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }
}

