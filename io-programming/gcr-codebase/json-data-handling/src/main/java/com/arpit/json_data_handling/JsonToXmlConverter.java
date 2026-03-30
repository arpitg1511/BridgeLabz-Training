package com.arpit.json_data_handling;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {

    public static void main(String[] args) {

        try {
            // Sample JSON string
            String jsonString =
                    "{"
                  + "\"name\":\"Arpit\","
                  + "\"age\":21,"
                  + "\"email\":\"arpit@example.com\""
                  + "}";

            // Convert JSON string to JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Convert JSONObject to XML
            String xml = XML.toString(jsonObject);

            System.out.println("XML Output:");
            System.out.println(xml);

        } catch (Exception e) {
            System.out.println("Error while converting JSON to XML");
        }
    }
}
