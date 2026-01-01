import java.util.*;

public class BankAccount {

    /* ---------- Static Members ---------- */

    // Shared across all BankAccount objects
    private static String bankName = "State Bank of India";

    // Counts total number of accounts created
    private static int totalAccounts = 0;

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    /* ---------- Instance Members ---------- */

    // Final variable: cannot be changed once assigned
    private final String accountNumber;

    private String accountHolderName;

    /* ---------- Constructor ---------- */

    // Uses 'this' to resolve ambiguity
    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    /* ---------- Instance Method ---------- */

    // Uses instanceof to check object type before displaying details
    public void displayDetails(Object obj) {
        if (obj instanceof BankAccount) {
            BankAccount acc = (BankAccount) obj;
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + acc.accountHolderName);
            System.out.println("Account Number: " + acc.accountNumber);
        } else {
            System.out.println("Object is not a BankAccount");
        }
    }

    /* ---------- Main Method ---------- */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String accNumber = sc.nextLine();
        String holderName = sc.nextLine();

        BankAccount account = new BankAccount(accNumber, holderName);

        account.displayDetails(account);

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}
