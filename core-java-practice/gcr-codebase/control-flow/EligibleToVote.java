import java.util.*;

public class EligibleToVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();

        // If age is 18 or more, the person is legally allowed to vote
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote.");
        } 
        // If age is less than 18, the person is not allowed to vote
        else {
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        sc.close();
    }
}
