package com.arpit.json_data_handling;

import org.json.JSONObject;

public class CarToJson {

    // Car class inside the same file
    static class Car {
        private String brand;
        private String model;
        private int year;

        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        // Getters
        public String getBrand() { return brand; }
        public String getModel() { return model; }
        public int getYear() { return year; }
    }

    public static void main(String[] args) {

        // Create a Car object
        Car car = new Car("Toyota", "Fortuner", 2022);

        // Convert Car object to JSON
        JSONObject json = new JSONObject();
        json.put("brand", car.getBrand());
        json.put("model", car.getModel());
        json.put("year", car.getYear());

        // Pretty print JSON
        System.out.println(json.toString(2));
    }
}
