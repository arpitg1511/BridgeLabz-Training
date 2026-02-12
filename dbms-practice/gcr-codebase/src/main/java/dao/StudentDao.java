package dao;

import config.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 🗄️ StudentDao — Data Access Object for the `students` table.
 *
 * Every method follows the same pattern:
 *   1. Write the SQL string with ? placeholders
 *   2. Open Connection + PreparedStatement (try-with-resources)
 *   3. Set the ? values
 *   4. Execute
 *   5. Auto-close (handled by try-with-resources)
 */
public class StudentDao {

    // ── CREATE ──────────────────────────────────────────────
    /**
     * Inserts a new student into the database.
     *
     * executeUpdate() is used for INSERT, UPDATE, DELETE
     * — it returns the number of rows affected.
     */
    public void insert(Student s) throws SQLException {
        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";
        //                                                     ↑   ↑   ↑
        //                                   placeholders — filled below

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());   // 1st ? → name
            ps.setString(2, s.getEmail());  // 2nd ? → email
            ps.setInt   (3, s.getAge());    // 3rd ? → age

            int rows = ps.executeUpdate();
            System.out.println("  ✅ " + rows + " row inserted.");
        }
    }

    // ── READ ALL ────────────────────────────────────────────
    /**
     * Returns every student in the table.
     *
     * executeQuery() is used for SELECT
     * — it returns a ResultSet (a cursor over the rows).
     *
     * rs.next() moves the cursor forward; returns false when no more rows.
     */
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT * FROM students ORDER BY id";
        List<Student> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),          // read column by name
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age")
                ));
            }
        }
        return list;
    }

    // ── READ ONE ────────────────────────────────────────────
    /**
     * Finds a student by ID. Returns Optional.empty() if not found.
     *
     * Why Optional? So the caller doesn't get a surprise null.
     */
    public Optional<Student> findById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    // ── UPDATE ──────────────────────────────────────────────
    /**
     * Updates an existing student by ID.
     */
    public void update(Student s) throws SQLException {
        String sql = "UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt   (3, s.getAge());
            ps.setInt   (4, s.getId());     // WHERE clause

            int rows = ps.executeUpdate();
            System.out.println("  ✏️ " + rows + " row updated.");
        }
    }

    // ── DELETE ──────────────────────────────────────────────
    /**
     * Deletes a student by ID.
     */
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println("  🗑️ " + rows + " row deleted.");
        }
    }
}