import java.util.*;

public class CartItem {

    String itemName;
    double price;
    int quantity;

    // Constructor
    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add items to cart
    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    // Method to remove items from cart
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than present.");
        }
    }

    // Method to calculate and display total cost
    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.printf("Total cost: %.2f\n", totalCost);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        String name = sc.nextLine();
        double price = sc.nextDouble();
        int quantity = sc.nextInt();

        CartItem item = new CartItem(name, price, quantity);

        // Initial item details
        System.out.printf("Item: %s, Price: %.2f, Quantity: %d\n",
                item.itemName, item.price, item.quantity);

        int addQty = sc.nextInt();
        item.addItem(addQty);

        int removeQty = sc.nextInt();
        item.removeItem(removeQty);

        item.displayTotalCost();

        sc.close();
    }
}
