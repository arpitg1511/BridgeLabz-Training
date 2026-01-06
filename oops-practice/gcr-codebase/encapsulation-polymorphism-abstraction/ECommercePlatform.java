// interface for tax operations
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

// abstract base class for all products
abstract class Product implements Taxable {

    private final String productId;
    private String name;
    private double price;

    // constructor
    Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // abstract method for discount
    abstract int calculateDiscount();

    // getters and setter
    String getName() {
        return name;
    }

    String getProductId() {
        return productId;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }
}

// Electronics product
class Electronics extends Product {

    Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    int calculateDiscount() {
        return 10; // flat discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Electronics Tax: 18%");
    }
}

// Clothing product
class Clothing extends Product {

    Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    int calculateDiscount() {
        return 20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Clothing Tax: 12%");
    }
}

// Groceries product
class Groceries extends Product {

    Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    int calculateDiscount() {
        return 5;
    }

    @Override
    public double calculateTax() {
        return 0; // no tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Groceries Tax: Nil");
    }
}

// main class
public class ECommercePlatform {

    // method to calculate and print final price for a single product
    static void printFinalPrice(Product p) {
        double tax = p.calculateTax();
        int discount = p.calculateDiscount();
        double finalPrice = p.getPrice() + tax - discount;

        System.out.println("Product: " + p.getName());
        p.getTaxDetails();
        System.out.println("Final Price: " + finalPrice);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {

        // create products
        Product e = new Electronics("E101", "Laptop", 60000);
        Product c = new Clothing("C201", "Jacket", 4000);
        Product g = new Groceries("G301", "Rice Bag", 1200);

        // calculate final price for each product
        printFinalPrice(e);
        printFinalPrice(c);
        printFinalPrice(g);
    }
}
