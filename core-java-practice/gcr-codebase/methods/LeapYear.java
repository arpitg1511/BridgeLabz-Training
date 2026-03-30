import java.util.*;

public class LeapYear {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println(leapyear(year));

        sc.close();
    }

    // Method to check leap year
    public static String leapyear(int year) {

        if (year >= 1582) {
            if (year % 400 == 0)
                return "Leap Year";
            else if (year % 100 == 0)
                return "Not a Leap Year";
            else if (year % 4 == 0)
                return "Leap Year";
            else
                return "Not a Leap Year";
        }

        return "Not a Leap Year";
    }
}
