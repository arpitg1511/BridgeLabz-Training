interface Vehicle {
    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery info not applicable");
    }
}

class PetrolCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Petrol Car Speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() {
        System.out.println("Electric Car Speed: 70 km/h");
    }

    public void displayBatteryPercentage() {
        System.out.println("Battery Level: 65%");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle v1 = new PetrolCar();
        Vehicle v2 = new ElectricCar();

        v1.displaySpeed();
        v1.displayBatteryPercentage();

        v2.displaySpeed();
        v2.displayBatteryPercentage();
    }
}
