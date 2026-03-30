package dao;

import config.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class BillDAO {

	public int generateBill(int visitId, double additionalCharges) throws SQLException {

		String fetchFeeSql = "SELECT d.consultation_fee FROM visits v JOIN appointments a ON v.appointment_id = a.id JOIN doctors d ON a.doctor_id = d.id WHERE v.id = ?";

		String insertSql = "INSERT INTO bills (visit_id, consultation_fee, additional_charges, total_amount, payment_status, bill_date) VALUES (?, ?, ?, ?, 'UNPAID', ?)";

		try (Connection conn = DBConnection.getConnection()) {
			double consultationFee;

			try (PreparedStatement fetchStmt = conn.prepareStatement(fetchFeeSql)) {
				fetchStmt.setInt(1, visitId);
				ResultSet rs = fetchStmt.executeQuery();

				if (!rs.next()) {
					throw new SQLException("Visit not found.");
				}

				consultationFee = rs.getDouble("consultation_fee");
			}
			double total = consultationFee + additionalCharges;
			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

				insertStmt.setInt(1, visitId);
				insertStmt.setDouble(2, consultationFee);
				insertStmt.setDouble(3, additionalCharges);
				insertStmt.setDouble(4, total);
				insertStmt.setDate(5, Date.valueOf(LocalDate.now()));

				int affectedRows = insertStmt.executeUpdate();
				if (affectedRows == 0) {
					throw new SQLException("Bill generation failed.");
				}

				ResultSet rs = insertStmt.getGeneratedKeys();
				if (rs.next()) {
					return rs.getInt(1);
				} else {
					throw new SQLException("No bill ID generated.");
				}
			}
		}
	}
}