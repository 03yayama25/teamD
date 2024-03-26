package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.DBUtil;

public class AccountDAO {

    public boolean registerAccount(String name, String pass) {
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO accounts (name, pass) VALUES (?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, pass);
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
