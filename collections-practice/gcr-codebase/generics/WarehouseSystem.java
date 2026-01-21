import java.util.ArrayList;
import java.util.List;

/* ---------- Abstract Base Class ---------- */
abstract class WarehouseItem {
    private final String name;

    protected WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Each item describes itself
    public abstract String getCategory();
}

/* ---------- Concrete Item Types ---------- */
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

/* ---------- Generic Storage Class ---------- */
class Storage<T extends WarehouseItem> {

    private final List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}

/* ---------- Utility Class Using Wildcards ---------- */
class WarehouseUtil {

    // Wildcard method: works for any WarehouseItem type
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(
                item.getCategory() + " Item: " + item.getName()
            );
        }
    }
}

/* ---------- Main Class ---------- */
public class WarehouseSystem {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("=== Electronics ===");
        WarehouseUtil.displayItems(electronicsStorage.getAllItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtil.displayItems(groceriesStorage.getAllItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtil.displayItems(furnitureStorage.getAllItems());
    }
}
