package ecommerce;

import java.util.*;

public class ECommerceApp {

    public static void main(String[] args) {

        Customer customer = new Customer(1, "Arpit");
        customer.displayCustomer();

        Product p1 = new Product(101, "Laptop", 60000);
        Product p2 = new Product(102, "Phone", 25000);

        p1.displayProduct();
        p2.displayProduct();

        List<String> products = new ArrayList<>();
        products.add(p1.getName());
        products.add(p2.getName());

        Order order = new Order(5001, products);

        order.displayProducts();
        order.trackOrder();

        Payment payment = new UPI();

        try {
            payment.pay(85000);
            System.out.println("Payment Successful");
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        order.setStatus("Shipped");
        order.trackOrder();
        
        order.displayProducts();
        order.cancelOrder();
        order.trackOrder();
    }
}
