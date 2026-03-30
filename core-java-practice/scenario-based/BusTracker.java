import java.util.Scanner;

public class BusTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        int stopNumber = 1;
        boolean isOnBus = true;

        while (isOnBus) {
            System.out.println("\n--- Stop " + stopNumber + " ---");
            System.out.print("Enter distance travelled to this stop (in km): ");
            int distance = sc.nextInt();

            totalDistance += distance;

            System.out.println("Total distance travelled so far: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("\nPassenger got off the bus.");
                System.out.println("Final distance travelled: " + totalDistance + " km");
                isOnBus = false;
            } else {
                stopNumber++;
            }
        }

        sc.close();
    }
}
