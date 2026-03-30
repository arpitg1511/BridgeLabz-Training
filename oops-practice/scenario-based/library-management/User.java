package library_management_system;

public class User {

    protected int userId;
    protected String name;

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

