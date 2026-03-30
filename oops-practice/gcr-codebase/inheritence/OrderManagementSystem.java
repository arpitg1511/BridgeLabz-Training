import java.util.*;

// Base class representing a generic Order
class Order {
    String orderId;
    String orderDate;

    // Constructor to initialize order details
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Returns basic order status
    String getOrderStatus() {
        return "Order Placed";
    }

    // Displays common order information
    void displayOrderDetails() {
        System.out.println("Order ID : " + orderId);
        System.out.println("Order Date : " + orderDate);
    }
}

// ShippedOrder class extends Order
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor initializes order and shipping details
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate); // initialize Order data
        this.trackingNumber = trackingNumber;
    }

    // Returns updated status after shipping
    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }

    // Displays shipping-specific details
    void displayShippingDetails() {
        System.out.println("Tracking Number : " + trackingNumber);
    }
}

// DeliveredOrder class extends ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor initializes order, shipping, and delivery details
    public DeliveredOrder(String orderId, String orderDate,
                          String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber); // initialize ShippedOrder data
        this.deliveryDate = deliveryDate;
    }

    // Returns final order status
    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }

    // Displays delivery-specific details
    void displayDeliveryDetails() {
        System.out.println("Delivery Date : " + deliveryDate);
    }
}

public class OrderManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for order details
        System.out.print("Enter Order ID: ");
        String orderId = sc.nextLine();

        System.out.print("Enter Order Date: ");
        String orderDate = sc.nextLine();

        // Taking input for shipping details
        System.out.print("Enter Tracking Number: ");
        String trackingNumber = sc.nextLine();

        // Taking input for delivery details
        System.out.print("Enter Delivery Date: ");
        String deliveryDate = sc.nextLine();

        // Parent reference pointing to most derived child object
        Order order = new DeliveredOrder(orderId, orderDate, trackingNumber, deliveryDate);

        // Method call resolved at runtime
        System.out.println("\nCurrent Status : " + order.getOrderStatus());

        // Displaying details using downcasting
        order.displayOrderDetails();

        if (order instanceof ShippedOrder) {
            ((ShippedOrder) order).displayShippingDetails();
        }

        if (order instanceof DeliveredOrder) {
            ((DeliveredOrder) order).displayDeliveryDetails();
        }

        sc.close();
    }
}
