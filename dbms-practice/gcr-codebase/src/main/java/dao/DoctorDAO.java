package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBConnection;
import model.Doctor;
import model.Specialty;

public class DoctorDAO {
	private SpecialtyDAO specialtyDAO = new SpecialtyDAO();

	public int addDoctor(Doctor doctor, String specialty) throws SQLException {
		int specialtyId = specialtyDAO.addSpecialty(new Specialty(specialty));
		String sql = "Insert into doctors (name, contact, consultation_fee, specialty_id) values (?, ?, ?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, doctor.getName());
			ps.setString(2, doctor.getContact());
			ps.setDouble(3, doctor.getConsultationFee());
			ps.setInt(4, specialtyId);
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Inserting doctor failed, no rows affected");
			}
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				} else {
					throw new SQLException("Inserting doctor failed, no ID obtained");
				}
			}
		}
	}

	public Doctor getDoctorById(int id) throws SQLException {
		String sql = "Select * from doctors where id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Doctor(rs.getInt("id"), rs.getString("name"), rs.getInt("specialty_id"),
							rs.getString("contact"), rs.getDouble("consultation_fee"));
				}
			}
		}
		return null;
	}
}