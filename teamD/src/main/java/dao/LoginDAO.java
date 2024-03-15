package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDAO {
    // データベース接続情報
    private final String url = "jdbc:mysql://localhost:3306/medicines_management";
    private final String username = "root";
    private final String password = "adminadmin";

    // データベース接続取得メソッド
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
