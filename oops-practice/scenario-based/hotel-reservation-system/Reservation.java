package hotel_reservation_system;

public class Reservation {

    private Guest guest;
    private Room room;
    private int days;

    Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }

    void display() {
        System.out.println(
            "Guest: " + guest.getName() +
            " Room: " + room.roomNumber +
            " Days: " + days
        );
    }
}

