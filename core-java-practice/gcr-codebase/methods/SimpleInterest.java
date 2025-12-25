import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int principal = sc.nextInt();
        int rate = sc.nextInt();
        int time = sc.nextInt();

        double si = simpleInterest(principal, rate, time);

        System.out.println(
            "The Simple Interest is " + si +
            " for Principal " + principal +
            ", Rate of Interest " + rate +
            " and Time " + time
        );

        sc.close();
    }

    // Method to calculate simple interest
    public static double simpleInterest(int principal, int rate, int time) {
        return (principal * rate * time) / 100.0;
    }
}
