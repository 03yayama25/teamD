package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medicine;
import model.MedicineTiming;
import utils.DBUtil;

public class MedicineAndTimingDAO {
    
    // 特定のユーザーの薬のリストを取得するメソッド
    public List<Medicine> getUserMedicines(int userId) throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT * FROM medicines_management.medicines WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Medicine medicine = new Medicine(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("medicine_name"),
                        resultSet.getString("type")
                    );
                    medicines.add(medicine);
                }
            }
        }
        return medicines;
    }
    
    // 特定の薬のタイミング情報を取得するメソッド
    public List<MedicineTiming> getMedicineTimings(int medicineId) throws SQLException {
        List<MedicineTiming> timings = new ArrayList<>();
        String sql = "SELECT * FROM medicines_management.medicines_timing WHERE medicines_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, medicineId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MedicineTiming timing = new MedicineTiming(
                        resultSet.getInt("id"),
                        resultSet.getInt("medicines_id"),
                        resultSet.getString("timing")
                    );
                    timings.add(timing);
                }
            }
        }
        return timings;
    }
}
