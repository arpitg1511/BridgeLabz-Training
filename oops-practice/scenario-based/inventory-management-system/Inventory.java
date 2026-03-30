package inventory_management_system;

import java.util.*;

public class Inventory {

    private List<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    void updateProductStock(int productId, int quantity) {
        for (Product p : products) {
            if (p.getId() == productId) {
                p.updateStock(quantity);
                System.out.println("Stock updated");
            }
        }
    }

    Product getProduct(int productId) {
        for (Product p : products) {
            if (p.getId() == productId) {
                return p;
            }
        }
        return null;
    }

    void displayInventory() {
        for (Product p : products) {
            p.displayProduct();
        }
    }
}
