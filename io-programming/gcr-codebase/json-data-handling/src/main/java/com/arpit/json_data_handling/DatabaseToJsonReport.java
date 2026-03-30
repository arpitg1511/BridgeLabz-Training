package com.arpit.json_data_handling;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseToJsonReport {

    public static void main(String[] args) {

        // Change these according to your DB
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "root";

        JSONArray reportArray = new JSONArray();

        try {
            // 1. Connect to database
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // 2. Execute query
            ResultSet rs = stmt.executeQuery(
                    "SELECT id, name, age, email FROM users"
            );

            // 3. Convert each row to JSON
            while (rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));
                obj.put("age", rs.getInt("age"));
                obj.put("email", rs.getString("email"));

                reportArray.put(obj);
            }

            // 4. Close connection
            rs.close();
            stmt.close();
            con.close();

            // 5. Print JSON report
            System.out.println(reportArray.toString(2));

        } catch (Exception e) {
            System.out.println("Error while generating JSON report");
        }
    }
}
