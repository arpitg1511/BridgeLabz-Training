package event_manager;

public class TicketApp {

    public static void main(String[] args) {

        Ticket[] tickets = {
            new Ticket(4500),
            new Ticket(1200),
            new Ticket(8000),
            new Ticket(3000),
            new Ticket(1500),
            new Ticket(6000),
            new Ticket(2000)
        };

        EventManager.quickSort(tickets, 0, tickets.length - 1);

        EventManager.displayTopCheapest(tickets, 5);
    }
}
