import java.util.ArrayList;
import java.util.List;

/* ---------- Category Hierarchy ---------- */

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

/* ---------- Generic Product Class ---------- */

class Product<T extends Category> {

    private final String name;
    private double price;
    private final T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " | " + category.getCategoryName() + " | Price: " + price;
    }
}

/* ---------- Generic Discount Utility ---------- */

class DiscountService {

    public static <P extends Product<?>> void applyDiscount(P product, double percentage) {

        if (percentage <= 0 || percentage > 100) {
            return;
        }

        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}

/* ---------- Driver Class ---------- */

public class MarketPlaceApp {

    public static void main(String[] args) {

        List<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book =
                new Product<>("Java Handbook", 500.0, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1200.0, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 25000.0, new GadgetCategory());

        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        DiscountService.applyDiscount(book, 10);
        DiscountService.applyDiscount(shirt, 20);
        DiscountService.applyDiscount(phone, 5);

        for (Product<? extends Category> product : catalog) {
            System.out.println(product);
        }
    }
}
