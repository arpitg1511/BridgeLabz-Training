package com.arpit.json_data_handling;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJsonConverter {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            String line;

            // Read header line (column names)
            String headerLine = br.readLine();
            String[] headers = headerLine.split(",");

            JSONArray jsonArray = new JSONArray();

            // Read remaining rows
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i].trim(), values[i].trim());
                }

                jsonArray.put(jsonObject);
            }

            br.close();

            // Print JSON result
            System.out.println(jsonArray.toString(2));

        } catch (Exception e) {
            System.out.println("Error while converting CSV to JSON");
        }
    }
}
