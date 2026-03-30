package com.arpit.json_data_handling;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtractJsonFields {

    public static void main(String[] args) {
        try {
            // Read the JSON file into a String
            String content = new String(Files.readAllBytes(Paths.get("student.json")));

            // Parse JSON
            JSONObject json = new JSONObject(content);

            // Extract specific fields
            String name = json.getString("name");
            String email = json.getString("email");

            // Print the extracted fields
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);

        } catch (Exception e) {
            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
