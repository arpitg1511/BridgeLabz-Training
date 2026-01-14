package inventory_management_system;

public class InventoryApp {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        AlertService alertService = new LowStockAlert();

        Product p1 = new Product(1, "Keyboard", 10);
        Product p2 = new Product(2, "Mouse", 4);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayInventory();

        try {
            p1.reduceStock(7);
            p2.reduceStock(2);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        alertService.checkStock(p1);
        alertService.checkStock(p2);

        inventory.displayInventory();
    }
}
