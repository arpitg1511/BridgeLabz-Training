package hotel_reservation_system;

public class HotelApp {

    public static void main(String[] args) {

        Guest g1 = new Guest(1, "Arpit");

        Room r1 = new StandardRoom(101);
        Room r2 = new DeluxeRoom(201);

        HotelService service = new HotelService();
        service.addRoom(r1);
        service.addRoom(r2);

        PricingStrategy normal = new NormalPricing();
        PricingStrategy seasonal = new SeasonalPricing();

        try {
            Reservation res = service.bookRoom(g1, r1, 3);
            res.display();

            double bill = service.generateInvoice(r1, 3, seasonal);
            System.out.println("Invoice Amount: ₹" + bill);

            service.checkout(r1);
        }
        catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.showReservations();
    }
}

