import java.util.*;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        // Spring season starts from March 20 and ends on June 20
        if (
            (month == 3 && day >= 20) ||   // From March 20 onwards
            (month == 4) ||                // Entire April
            (month == 5) ||                // Entire May
            (month == 6 && day <= 20)      // Up to June 20
        ) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        sc.close();
    }
}
