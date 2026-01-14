package hotel_reservation_system;

public class Guest {

    private final int guestId;
    private String name;

    Guest(int id, String name) {
        this.guestId = id;
        this.name = name;
    }

    int getId() {
        return guestId;
    }

    String getName() {
        return name;
    }
}

