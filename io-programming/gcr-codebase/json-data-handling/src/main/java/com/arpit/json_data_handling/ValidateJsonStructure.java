package com.arpit.json_data_handling;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonStructure {

    public static void main(String[] args) {

        try {
            // JSON string (Java 8 compatible)
            String jsonString =
                    "{"
                  + "\"name\":\"Arpit Gupta\","
                  + "\"email\":\"arpit@example.com\","
                  + "\"age\":21"
                  + "}";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonString);

            // Simple structure validation
            boolean isValid =
                    rootNode.has("name") &&
                    rootNode.has("email") &&
                    rootNode.has("age");

            if (isValid) {
                System.out.println("JSON structure is valid");
            } else {
                System.out.println("JSON structure is invalid");
            }

        } catch (Exception e) {
            System.out.println("Invalid JSON format");
        }
    }
}
