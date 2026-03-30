package dao;

import config.DBConnection;
import model.Visit;

import java.sql.*;

public class VisitDAO {

	public int recordVisit(Visit visit) throws SQLException {

		String insertVisitSql = "INSERT INTO visits (appointment_id, visit_date, diagnosis, notes) VALUES (?, ?, ?, ?)";

		String updateAppointmentSql = "UPDATE appointments SET status = 'COMPLETED' WHERE id = ?";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);
			try (PreparedStatement visitStmt = conn.prepareStatement(insertVisitSql, Statement.RETURN_GENERATED_KEYS)) {

				visitStmt.setInt(1, visit.getAppointmentId());
				visitStmt.setDate(2, Date.valueOf(visit.getVisitDate()));
				visitStmt.setString(3, visit.getDiagnosis());
				visitStmt.setString(4, visit.getNotes());

				int affectedRows = visitStmt.executeUpdate();

				if (affectedRows == 0) {
					conn.rollback();
					throw new SQLException("Visit insertion failed.");
				}

				ResultSet rs = visitStmt.getGeneratedKeys();
				if (!rs.next()) {
					conn.rollback();
					throw new SQLException("No visit ID generated.");
				}

				int visitId = rs.getInt(1);
				try (PreparedStatement updateStmt = conn.prepareStatement(updateAppointmentSql)) {

					updateStmt.setInt(1, visit.getAppointmentId());
					int updated = updateStmt.executeUpdate();

					if (updated == 0) {
						conn.rollback();
						throw new SQLException("Appointment update failed.");
					}
				}

				conn.commit();
				return visitId;
			}

		}
	}
}