package inventory_management_system;

public class Product {

    private final int productId;
    private String productName;
    private int stock;

    Product(int id, String name, int stock) {
        this.productId = id;
        this.productName = name;
        this.stock = stock;
    }

    int getId() {
        return productId;
    }

    String getName() {
        return productName;
    }

    int getStock() {
        return stock;
    }

    void updateStock(int quantity) {
        this.stock += quantity;
    }

    void reduceStock(int quantity) throws OutOfStockException {
        if (stock < quantity) {
            throw new OutOfStockException("Product out of stock: " + productName);
        }
        stock -= quantity;
    }

    void displayProduct() {
        System.out.println(productId + " " + productName + " Stock: " + stock);
    }
}
