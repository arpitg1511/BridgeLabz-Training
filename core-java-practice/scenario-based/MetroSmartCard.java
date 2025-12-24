import java.util.*;

public class MetroSmartCard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 200;   // initial smart card balance
        char choice = 'Y';

        while (balance > 0 && choice == 'Y') {

            System.out.print("Enter distance travelled (in km): ");
            int distance = sc.nextInt();

            // Fare calculation using ternary operator
            int fare = (distance <= 5) ? 10 : (distance <= 10) ? 20 : 30;

            if (balance >= fare) {
                balance = balance - fare;
                System.out.println("Fare deducted: " + fare);
                System.out.println("Remaining balance: " + balance);
            }

            System.out.print("Do you want to continue? (Y/N): ");
            choice = sc.next().charAt(0);
        }

        sc.close();
    }
}
