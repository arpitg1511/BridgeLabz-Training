package ECommerce_Sorting;

import java.util.*;

public class ECommerceSorting {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 70000, 4.5, 10));
        products.add(new Product("Phone", 45000, 4.2, 15));
        products.add(new Product("Headphones", 3000, 4.8, 25));
        products.add(new Product("Smart Watch", 12000, 4.1, 20));

        // Campaign type
        String campaign = "DISCOUNT"; // PRICE, RATING, DISCOUNT

        Comparator<Product> comparator;

        switch (campaign) {
            case "PRICE":
                comparator = (p1, p2) -> Double.compare(p1.price, p2.price);
                break;

            case "RATING":
                comparator = (p1, p2) -> Double.compare(p2.rating, p1.rating);
                break;

            case "DISCOUNT":
                comparator = (p1, p2) -> Double.compare(p2.discount, p1.discount);
                break;

            default:
                throw new IllegalArgumentException("Invalid campaign type");
        }

        Collections.sort(products, comparator);

        products.forEach(System.out::println);
    }
}

