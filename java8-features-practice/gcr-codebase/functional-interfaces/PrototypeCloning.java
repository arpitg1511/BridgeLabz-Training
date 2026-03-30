class Product implements Cloneable {

    int productId;
    String productName;

    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    // Overriding clone() method
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void display() {
        System.out.println(productId + " - " + productName);
    }
}

public class PrototypeCloning {

    public static void main(String[] args) {
        try {
            Product original = new Product(101, "Laptop");
            Product copy = (Product) original.clone();

            System.out.println("Original Product:");
            original.display();

            System.out.println("Cloned Product:");
            copy.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}
