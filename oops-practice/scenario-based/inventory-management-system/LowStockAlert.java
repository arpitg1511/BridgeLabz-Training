package inventory_management_system;

public class LowStockAlert implements AlertService {

    private static final int LOW_STOCK_LIMIT = 5;

    @Override
    public void checkStock(Product product) {
        if (product.getStock() <= LOW_STOCK_LIMIT) {
            System.out.println("⚠ Low Stock Alert for: " + product.getName());
        }
    }
}

