package event_manager;

class EventManager {

    // Quick Sort entry
    static void quickSort(Ticket[] tickets, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(tickets, low, high);

            quickSort(tickets, low, pivotIndex - 1);
            quickSort(tickets, pivotIndex + 1, high);
        }
    }

    // partition logic
    static int partition(Ticket[] tickets, int low, int high) {

        int pivot = tickets[high].price;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (tickets[j].price <= pivot) {
                i++;
                swap(tickets, i, j);
            }
        }

        swap(tickets, i + 1, high);
        return i + 1;
    }

    static void swap(Ticket[] tickets, int i, int j) {
        Ticket temp = tickets[i];
        tickets[i] = tickets[j];
        tickets[j] = temp;
    }

    // display top N cheapest tickets
    static void displayTopCheapest(Ticket[] tickets, int n) {

        System.out.println("Top " + n + " Cheapest Tickets:");
        for (int i = 0; i < n && i < tickets.length; i++) {
            System.out.println("₹" + tickets[i].price);
        }
    }
}
