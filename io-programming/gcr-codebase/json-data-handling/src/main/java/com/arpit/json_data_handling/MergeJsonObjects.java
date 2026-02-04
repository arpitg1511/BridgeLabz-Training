package com.arpit.json_data_handling;

import org.json.JSONObject;

public class MergeJsonObjects {

    public static void main(String[] args) {

        // First JSON object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Arpit");
        json1.put("email", "arpit@example.com");

        // Second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("age", 21);
        json2.put("city", "Mathura");

        // Merge json2 into json1
        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        // Final merged JSON
        System.out.println(json1.toString(2));
    }
}
