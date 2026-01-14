package digital_wallet_system;

public class User {

    private final int userId;
    private String name;

    User(int id, String name) {
        this.userId = id;
        this.name = name;
    }

    int getId() {
        return userId;
    }

    String getName() {
        return name;
    }
}

