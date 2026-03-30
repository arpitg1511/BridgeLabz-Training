// interface for discount related operations
interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

// abstract base class for all food items
abstract class FoodItem implements Discountable {

    private String itemName;
    protected double price;
    private int quantity;

    // constructor
    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // abstract method
    abstract double calculateTotalPrice();

    // concrete method
    void getItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
        System.out.println("Quantity  : " + quantity);
    }

    // controlled access (encapsulation)
    int getQuantity() {
        return quantity;
    }
}

// veg food item
class VegItem extends FoodItem {

    VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return price * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: 10%");
    }
}

// non-veg food item
class NonVegItem extends FoodItem {

    NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return (price * getQuantity()) + 50; // extra charge
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: 5%");
    }
}

// main class
public class FoodDelieverySystem {

    // polymorphic method (same structure as earlier systems)
    static void processOrder(FoodItem item) {

        item.getItemDetails();
        double total = item.calculateTotalPrice();
        double discount = item.applyDiscount();
        double finalAmount = total - discount;

        item.getDiscountDetails();
        System.out.println("Total Price : " + total);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        FoodItem veg = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem nonVeg = new NonVegItem("Chicken Biryani", 300, 1);

        processOrder(veg);
        processOrder(nonVeg);
    }
}
