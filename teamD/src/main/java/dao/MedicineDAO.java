package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medicine;
import utils.DBUtil;

public class MedicineDAO {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/medicines_management";
    private final String DB_USER = "root";
    private final String DB_PASS = "adminadmin";

    public boolean registerMedicine(String name, String type) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	
            try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
                String sql = "INSERT INTO medicines (name, type) VALUES (?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, name);
                    statement.setString(2, type);
                    int rowsInserted = statement.executeUpdate();
                    return rowsInserted > 0;
               }
           }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // エラーハンドリング
            return false;
        }

 
    }
  
  
  /* まだテストしてないコード↓ miyahara */
    // 朝の服薬情報を取得するメソッド
    public static List<Medicine> getMorningMedicines(int userId) {
        List<Medicine> morningMedicines = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT m.id, m.name, m.type FROM medicines_timing mt INNER JOIN medicines m ON mt.medicines_id = m.id WHERE mt.user_id = ? AND mt.timing = '朝'");
        ) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Medicine medicine = new Medicine();
                    medicine.setId(resultSet.getInt("id"));
                    medicine.setName(resultSet.getString("name"));
                    medicine.setType(resultSet.getString("type"));
                    morningMedicines.add(medicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return morningMedicines;

    // 昼の服薬情報を取得するメソッド
    public static List<Medicine> getNoonMedicines(int userId) {
        List<Medicine> noonMedicines = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT m.id, m.name, m.type FROM medicines_timing mt INNER JOIN medicines m ON mt.medicines_id = m.id WHERE mt.user_id = ? AND mt.timing = '昼'");
        ) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Medicine medicine = new Medicine();
                    medicine.setId(resultSet.getInt("id"));
                    medicine.setName(resultSet.getString("name"));
                    medicine.setType(resultSet.getString("type"));
                    noonMedicines.add(medicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noonMedicines;
    }

    // 晩の服薬情報を取得するメソッド
    public static List<Medicine> getEveningMedicines(int userId) {
        List<Medicine> eveningMedicines = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT m.id, m.name, m.type FROM medicines_timing mt INNER JOIN medicines m ON mt.medicines_id = m.id WHERE mt.user_id = ? AND mt.timing = '晩'");
        ) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Medicine medicine = new Medicine();
                    medicine.setId(resultSet.getInt("id"));
                    medicine.setName(resultSet.getString("name"));
                    medicine.setType(resultSet.getString("type"));
                    eveningMedicines.add(medicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eveningMedicines;
    }

    // とん服の服薬情報を取得するメソッド
    public static List<Medicine> getExtraMedicines(int userId) {
        List<Medicine> extraMedicines = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement("SELECT m.id, m.name, m.type FROM medicines_timing mt INNER JOIN medicines m ON mt.medicines_id = m.id WHERE mt.user_id = ? AND mt.timing = 'とん服'");
        ) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Medicine medicine = new Medicine();
                    medicine.setId(resultSet.getInt("id"));
                    medicine.setName(resultSet.getString("name"));
                    medicine.setType(resultSet.getString("type"));
                    extraMedicines.add(medicine);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraMedicines;
    }

}
