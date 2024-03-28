package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Medicine;
import utils.DBUtil;

public class MedicineDAO {
	public int addMedicine(Medicine medicine) throws SQLException {
	    String sql = "INSERT INTO medicines_management.medicines (user_id, medicine_name, type) VALUES (?, ?, ?)";
	    try (Connection conn = DBUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        statement.setInt(1, medicine.getUserId());
	        statement.setString(2, medicine.getName());
	        statement.setString(3, medicine.getType());
	        int affectedRows = statement.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Failed to add medicine, no rows affected.");
	        }
	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Failed to retrieve generated medicine ID.");
	            }
	        }
	    }
	}
}