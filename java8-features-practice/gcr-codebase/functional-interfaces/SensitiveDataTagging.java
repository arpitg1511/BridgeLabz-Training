// Marker Interface (no methods)
interface SensitiveData {
}

// Class marked as sensitive
class UserCredentials implements SensitiveData {
    String username;
    String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

// Normal class (not sensitive)
class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

public class SensitiveDataTagging {

    // Method that checks marker interface
    static void processData(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Sensitive data detected -> Encrypt before storing");
        } else {
            System.out.println("Normal data -> Store directly");
        }
    }

    public static void main(String[] args) {

        UserCredentials user = new UserCredentials("arpit", "secret123");
        Product product = new Product("Laptop");

        processData(user);
        processData(product);
    }
}
