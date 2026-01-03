import java.util.*;

// Base class representing a generic Device
class Device {
    String deviceId;
    String status;

    // Constructor to initialize device details
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Displays basic device status
    void displayStatus() {
        System.out.println("Device ID : " + deviceId);
        System.out.println("Status : " + status);
    }
}

// Thermostat class inherits properties of Device
class Thermostat extends Device {
    int temperatureSetting;

    // Constructor initializes both device and thermostat details
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status); // initialize Device data
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to display thermostat-specific status
    @Override
    void displayStatus() {
        super.displayStatus(); // reuse Device's display logic
        System.out.println("Temperature Setting : " + temperatureSetting + " C");
    }
}

public class SmartHomeSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for device details
        System.out.print("Enter Device ID: ");
        String deviceId = sc.nextLine();

        System.out.print("Enter Device Status: ");
        String status = sc.nextLine();

        // Taking input for thermostat details
        System.out.print("Enter Temperature Setting: ");
        int temperature = sc.nextInt();

        // Parent reference pointing to child object
        Device d = new Thermostat(deviceId, status, temperature);

        // Method call resolved at runtime
        d.displayStatus();

        sc.close();
    }
}
