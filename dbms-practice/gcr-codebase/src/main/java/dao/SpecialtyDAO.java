package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Specialty;

public class SpecialtyDAO {
	public int addSpecialty(Specialty specialty) throws SQLException {
		String sql = "Select id from specialties where name = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, specialty.getName());
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("id");
				}
			}
		}

		String insertSql = "Insert into specialties (name) values (?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, specialty.getName());
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Inserting specialties failed, no rows affected.");
			}
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		}
		return -1;
	}

	public List<Specialty> getAllSpecialties() throws SQLException {
		List<Specialty> list = new ArrayList<Specialty>();
		String sql = "Select * from specialties";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new Specialty(rs.getInt("id"), rs.getString("name")));
				}
			}
		}
		return list;
	}
}