package com.arpit.json_data_handling;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReadJsonAndPrint {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("data.json"));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            // Convert to JSONObject
            JSONObject json = new JSONObject(sb.toString());

            // Print all keys and values
            for (String key : json.keySet()) {
                System.out.println(key + " : " + json.get(key));
            }

        } catch (Exception e) {
            System.out.println("Error while reading JSON file");
        }
    }
}
