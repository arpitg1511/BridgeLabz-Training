package hotel_reservation_system;

import java.util.*;

public class HotelService {

    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    void addRoom(Room room) {
        rooms.add(room);
    }

    Reservation bookRoom(
            Guest guest,
            Room room,
            int days
    ) throws RoomNotAvailableException {

        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available");
        }

        room.book();
        Reservation r = new Reservation(guest, room, days);
        reservations.add(r);
        return r;
    }

    void checkout(Room room) {
        room.checkout();
        System.out.println("Checked out successfully");
    }

    double generateInvoice(
            Room room,
            int days,
            PricingStrategy pricing
    ) {
        return pricing.calculatePrice(room.getBasePrice(), days);
    }

    void showReservations() {
        for (Reservation r : reservations) {
            r.display();
        }
    }
}

