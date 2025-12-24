import java.util.*;

public class PollingBoothSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        System.out.println("To exit voting type 'N'");
        System.out.println("To continue voting press 'Y'");
        char status = Character.toUpperCase(sc.next().charAt(0));

        while (status == 'Y') {

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                System.out.println("Invalid Age");
            } else {
                System.out.println("Candidates are : 1\t2\t3");
                System.out.print("Your Vote : ");
                int vote = sc.nextInt();

                if (vote < 1 || vote > 3) {
                    System.out.println("No such candidate present");
                } else {
                    if (vote == 1) a++;
                    else if (vote == 2) b++;
                    else c++;
                }
            }

            System.out.println("To exit voting type 'N'");
            System.out.println("To continue voting press 'Y'");
            status = Character.toUpperCase(sc.next().charAt(0));
        }

        // Commissioner access
        System.out.print("\nEnter Commissioner Code to view results: ");
        int code = sc.nextInt();

        if (code == 1234) {   // commissioner code
            System.out.println("\nVoting Results:");
            System.out.println("Candidate 1: " + a);
            System.out.println("Candidate 2: " + b);
            System.out.println("Candidate 3: " + c);
        }

        sc.close();
    }
}
