package dao;

import config.DBConnection;
import model.Appointment;

import java.sql.*;

public class AppointmentDAO {

	public int bookAppointment(Appointment appointment) throws SQLException {

		String checkSql = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date = ? AND appointment_time = ? AND status = 'SCHEDULED'";

		String insertSql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);
			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

				checkStmt.setInt(1, appointment.getDoctorId());
				checkStmt.setDate(2, Date.valueOf(appointment.getAppointmentDate()));
				checkStmt.setTime(3, Time.valueOf(appointment.getAppointmentTime()));

				ResultSet rs = checkStmt.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					conn.rollback();
					throw new SQLException("Doctor not available at this time.");
				}
			}
			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {

				insertStmt.setInt(1, appointment.getPatientId());
				insertStmt.setInt(2, appointment.getDoctorId());
				insertStmt.setDate(3, Date.valueOf(appointment.getAppointmentDate()));
				insertStmt.setTime(4, Time.valueOf(appointment.getAppointmentTime()));
				insertStmt.setString(5, appointment.getStatus());

				int affectedRows = insertStmt.executeUpdate();

				if (affectedRows == 0) {
					conn.rollback();
					throw new SQLException("Booking failed.");
				}

				ResultSet rs = insertStmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					conn.commit();
					return id;
				} else {
					conn.rollback();
					throw new SQLException("No ID generated.");
				}
			}
		}
	}
}