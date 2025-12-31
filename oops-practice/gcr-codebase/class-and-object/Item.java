import java.util.*;

public class Item {

    // Instance variables to store item details
    String itemCode;
    double itemPrice;
    String itemName;

    // Constructor to initialize item details
    public Item(String itemCode, double itemPrice, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    // Method to calculate total price based on quantity
    double totalPrice(int quantity) {
        return quantity * itemPrice;
    }

    // Method to display item details
    void display() {
        System.out.println("itemCode: " + itemCode);
        System.out.printf("itemPrice: %.2f\n", itemPrice);
        System.out.println("itemName: " + itemName);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read item code and price
        String code = sc.next();
        double price = sc.nextDouble();

        // Consume leftover newline before reading item name
        sc.nextLine();
        String name = sc.nextLine();

        // Create Item object
        Item i = new Item(code, price, name);

        // Read quantity
        int quantity = sc.nextInt();

        // Display item details and total price
        i.display();
        System.out.println(i.totalPrice(quantity));

        // Close the scanner
        sc.close();
    }
}
