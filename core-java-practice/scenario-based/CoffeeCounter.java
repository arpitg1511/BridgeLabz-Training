import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String coffeeType = sc.next(); // coffee type or "exit"

            if (coffeeType.equalsIgnoreCase("exit")) {
                break;
            }

            int quantity = sc.nextInt();
            double price = 0;

            // Determine price based on coffee type
            switch (coffeeType) {
                case "Espresso":
                    price = 100;
                    break;
                case "Latte":
                    price = 120;
                    break;
                case "Cappuccino":
                    price = 150;
                    break;
                default:
                    continue; // skip invalid coffee type
            }

            double total = price * quantity;
            double gst = total * 0.05; // 5% GST
            double finalBill = total + gst;

            System.out.println(finalBill);
        }

        sc.close();
    }
}
