package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBUtil;

public class LoginDAO {
    private Connection conn;

    public LoginDAO() {
        try {
            this.conn = DBUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // エラー処理
        }
    }

    public boolean checkLogin(String name, String pass) {
        String sql = "SELECT * FROM accounts WHERE name = ? AND pass = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, pass);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // 結果が存在するかどうかを取得
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
