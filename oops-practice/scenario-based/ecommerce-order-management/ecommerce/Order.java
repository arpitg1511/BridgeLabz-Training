package ecommerce;

import java.util.*;

public class Order {

    private final int orderId;
    private List<String> productList;
    private String status;

    Order(int id, List<String> products) {
        this.orderId = id;
        this.productList = products;
        this.status = "Placed";
    }

    int getID() {
        return orderId;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    void cancelOrder() {
        setStatus("Cancelled");
    }

    void trackOrder() {
        System.out.println("Order Status : " + status);
    }

    void displayProducts() {
        for (String p : productList) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
