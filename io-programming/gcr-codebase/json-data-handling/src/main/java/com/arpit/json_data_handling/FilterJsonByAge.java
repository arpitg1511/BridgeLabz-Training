package com.arpit.json_data_handling;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterJsonByAge {

    public static void main(String[] args) {

        // Sample JSON array string
        String jsonString =
                "[" +
                "{\"name\":\"Arpit\",\"age\":21}," +
                "{\"name\":\"Rahul\",\"age\":28}," +
                "{\"name\":\"Neha\",\"age\":26}," +
                "{\"name\":\"Aman\",\"age\":23}" +
                "]";

        // Parse JSON array
        JSONArray jsonArray = new JSONArray(jsonString);
        JSONArray filteredArray = new JSONArray();

        // Filter records where age > 25
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            int age = obj.getInt("age");

            if (age > 25) {
                filteredArray.put(obj);
            }
        }

        // Print filtered result
        System.out.println(filteredArray.toString(2));
    }
}
