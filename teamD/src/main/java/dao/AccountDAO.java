package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/medicines_management";
    private final String DB_USER = "root";
    private final String DB_PASS = "adminadmin";

    public boolean registerAccount(String name, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
                String sql = "INSERT INTO accounts (name, pass) VALUES (?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, name);
                    statement.setString(2, pass);
                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // エラーハンドリング
            return false;
        }
    }
}