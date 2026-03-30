import java.util.*;

class ShoppingCart {
    Map<String, Integer> price = new HashMap<>();
    Map<String, Integer> cart = new LinkedHashMap<>();

    void addProduct(String p, int v) {
        price.put(p, v);
    }

    void addToCart(String p) {
        cart.put(p, price.get(p));
    }

    void showSortedByPrice() {
        TreeMap<Integer, List<String>> t = new TreeMap<>();

        for (String k : cart.keySet()) {
            int val = cart.get(k);
            if (!t.containsKey(val)) {
                t.put(val, new ArrayList<>());
            }
            t.get(val).add(k);
        }

        // Display
        for (int price : t.keySet()) {
            System.out.println(price + ": " + t.get(price));
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {

        ShoppingCart c = new ShoppingCart();

        // ======= Input from program =======
        // Products and their prices
        c.addProduct("Apple", 50);
        c.addProduct("Banana", 30);
        c.addProduct("Orange", 50);
        c.addProduct("Mango", 40);

        // Add items to cart
        c.addToCart("Apple");
        c.addToCart("Orange");
        c.addToCart("Banana");
        c.addToCart("Mango");

        // ======= Show outputs =======
        System.out.println("Cart: " + c.cart);
        System.out.println("Sorted by price:");
        c.showSortedByPrice();
    }
}
