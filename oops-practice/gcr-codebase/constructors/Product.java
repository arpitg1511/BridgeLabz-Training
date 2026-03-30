import java.util.*;
public class Product {

    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared among all Product objects)
    private static int totalProducts = 0;

    // Parameterized constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.printf("Price: %.2f\n", price);
    }

    // Class method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input first product
        String name1 = sc.nextLine();
        double price1 = sc.nextDouble();
        sc.nextLine(); // consume newline

        Product p1 = new Product(name1, price1);

        // Input second product
        String name2 = sc.nextLine();
        double price2 = sc.nextDouble();

        Product p2 = new Product(name2, price2);

        // Display product details
        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        // Display total products created
        Product.displayTotalProducts();

        sc.close();
    }
}
