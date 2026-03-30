import java.util.*;

public class MobilePhone {

    // Instance variables to store mobile phone details
    String brand;
    String model;
    double price;

    // Constructor to initialize brand, model, and price
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    void display() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.printf("Price of mobile: %.2f\n", price);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read brand, model, and price from user
        MobilePhone mp = new MobilePhone(
                sc.nextLine(),   // brand
                sc.nextLine(),       // model
                sc.nextDouble()  // price
        );

        // Display mobile phone information
        mp.display();

        // Close the scanner resource
        sc.close();
    }
}
