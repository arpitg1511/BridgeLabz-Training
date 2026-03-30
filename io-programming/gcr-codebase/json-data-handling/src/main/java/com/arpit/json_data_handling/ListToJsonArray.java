package com.arpit.json_data_handling;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

// Simple POJO class
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ListToJsonArray {

    public static void main(String[] args) {

        // Create list of objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Arpit", 21));
        students.add(new Student("Rahul", 22));
        students.add(new Student("Neha", 20));

        // JSON array
        JSONArray jsonArray = new JSONArray();

        // Convert each object to JSON
        for (Student s : students) {
            JSONObject json = new JSONObject();
            json.put("name", s.name);
            json.put("age", s.age);

            jsonArray.put(json);
        }

        // Print JSON array
        System.out.println(jsonArray.toString(2));
    }
}
