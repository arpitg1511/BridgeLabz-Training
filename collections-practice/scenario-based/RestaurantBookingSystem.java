import java.util.*;

// ------------------ Custom Checked Exception ------------------
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

// ------------------ Table Class ------------------
class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}

// ------------------ Reservation Class ------------------
class Reservation {
    private int tableNumber;
    private String timeSlot;

    public Reservation(int tableNumber, String timeSlot) {
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}

// ------------------ Restaurant Class ------------------
class Restaurant {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    // Add tables
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // Reserve table
    public void reserveTable(int tableNumber, String timeSlot)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot)) {

                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, timeSlot));
        System.out.println("Table " + tableNumber + " reserved for " + timeSlot);
    }

    // Cancel reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r ->
                r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot));

        System.out.println("Reservation cancelled for table " + tableNumber);
    }

    // Show available tables
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equals(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if (!reserved) {
                System.out.println("Table " + table.getTableNumber() +
                        " (Capacity: " + table.getCapacity() + ")");
            }
        }
    }
}

// ------------------ Main Class ------------------
public class RestaurantBookingSystem{
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        // Add tables
        restaurant.addTable(new Table(1, 4));
        restaurant.addTable(new Table(2, 2));
        restaurant.addTable(new Table(3, 6));

        try {
            restaurant.reserveTable(1, "7PM-8PM");
            restaurant.reserveTable(2, "7PM-8PM");

            // Double booking (will throw exception)
            restaurant.reserveTable(1, "7PM-8PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        restaurant.showAvailableTables("7PM-8PM");

        restaurant.cancelReservation(2, "7PM-8PM");

        restaurant.showAvailableTables("7PM-8PM");
    }
}
