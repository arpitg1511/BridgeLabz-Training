class TicketNode {
	int ticketId;
	String customerName;
	String movieName;
	int seatNumber;
	String bookingTime;
	TicketNode next;
	TicketNode(int ticketId, String customerName, String movieName, int seatNumber,
				String bookingTime) {
		
		this.ticketId = ticketId;
		this.customerName = customerName;
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.bookingTime = bookingTime;
		this.next = null;
		
	}
	
	void display() {
		System.out.println("Ticket ID : " + ticketId +
							"\ncustomerName : " + customerName +
							"\nMovie Name : " + movieName +
							"\nSeat No. : " + seatNumber +
							"\nBooking Time : " + bookingTime);
	}
}
public class OnlneTicketReservationSystem {

    public static void main(String[] args) {

        // 1️⃣ Create first booking (circular list start)
        TicketNode head = addReservation(null, 1, "Farhan Khan", "Alif Laila", 1, "00:00");

        // 2️⃣ Add reservations
        head = addReservation(head, 2, "Uraan", "Sometimes", 2, "23:25");
        head = addReservation(head, 3, "Jokhay", "KhanaBadosh", 3, "19:21");
        head = addReservation(head, 4, "Farhan Khan", "Khan Saab", 4, "20:10");

        // 3️⃣ Display all tickets
        System.out.println("\nAll Bookings:");
        displayAll(head);

        // 4️⃣ Search by Movie Name
        System.out.println("\nSearch by Movie Name: Sometimes");
        searchByMovieName(head, "Sometimes");

        // 5️⃣ Search by Customer Name
        System.out.println("\nSearch by Customer Name: Farhan Khan");
        searchByCustomerName(head, "Farhan Khan");

        // 6️⃣ Count total tickets
        System.out.println("\nTotal Tickets Booked: " + countTickets(head));

        // 7️⃣ Remove a ticket
        System.out.println("\nRemoving Ticket ID 2");
        head = removeNode(head, 2);

        // 8️⃣ Display after deletion
        System.out.println("\nBookings After Deletion:");
        displayAll(head);

        // 9️⃣ Count tickets again
        System.out.println("\nTotal Tickets After Deletion: " + countTickets(head));
    }

    // ---------------- METHODS (UNCHANGED) ----------------
    
    static TicketNode addReservation(TicketNode head, int ticketId, String customerName, 
            String movieName, int seatNumber, String bookingTime) {
        
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        
        if(head == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        TicketNode temp = head;
        while(temp.next != head) {
            temp = temp.next;
        }
        
        temp.next = newNode;
        newNode.next = head;
        
        return head;
    }

    static TicketNode removeNode(TicketNode head, int ticketId) {
        if(head == null) {
            System.out.println("No booking done till now");
            return head;
        }
        
        if(head.next == head && head.ticketId == ticketId) return null;
        
        if(head.ticketId == ticketId) {
            TicketNode temp = head;
            while(temp.next != head) temp = temp.next;
            temp.next = head.next;
            return head.next;
        }
        
        TicketNode temp = head;
        do {
            if(temp.next.ticketId == ticketId) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        } while(temp != head);
        
        System.out.println("No such ticket found");
        return head;
    }

    static void searchByMovieName(TicketNode head, String movieName) {
        if(head == null) {
            System.out.println("No such movie found");
            return;
        }
        
        TicketNode temp = head;
        do {
            if(temp.movieName.equalsIgnoreCase(movieName)) {
                temp.display();
                return;
            }
            temp = temp.next;
        } while(temp != head);
        
        System.out.println("No such movie found");
    }

    static void searchByCustomerName(TicketNode head, String customerName) {
        if(head == null) {
            System.out.println("No such customer found");
            return;
        }
        
        TicketNode temp = head;
        do {
            if(temp.customerName.equalsIgnoreCase(customerName)) {
                temp.display();
                return;
            }
            temp = temp.next;
        } while(temp != head);
        
        System.out.println("No such customer found");
    }

    static int countTickets(TicketNode head) {
        if(head == null) return 0;
        
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while(temp != head);
        
        return count;
    }

    static void displayAll(TicketNode head) {
        if(head == null) {
            System.out.println("Empty List !!!!");
            return;
        }
        
        TicketNode temp = head;
        do {
            temp.display();
            temp = temp.next;
        } while(temp != head);
    }
}
