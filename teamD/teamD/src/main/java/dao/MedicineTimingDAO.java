package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.MedicineTiming;
import utils.DBUtil;

public class MedicineTimingDAO { //薬のタイミング情報をデータベースに追加するメソッド
    public void addMedicineTimings(List<MedicineTiming> timingList) throws SQLException {
    	//SQL文 medicines_timingテーブルへ
        String sql = "INSERT INTO medicines_management.medicines_timing (medicines_id, timing) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            for (MedicineTiming timing : timingList) {
                statement.setInt(1, timing.getMedicineId());
                statement.setString(2, timing.getTiming());
                statement.executeUpdate();
            }
        }
    }
}
