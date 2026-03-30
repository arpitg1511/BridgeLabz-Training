import java.util.Scanner;

// Superclass
class BankAccount {
    public int accountNumber;       // public: accessible everywhere
    protected String accountHolder; // protected: accessible in subclass
    private double balance;         // private: accessible only in this class

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public setter for balance
    public void setBalance(double balance) {
        if(balance >= 0)
            this.balance = balance;
        else
            System.out.println("Balance cannot be negative!");
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Subclass demonstrating access to public and protected members
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsDetails() {
        // Access public accountNumber directly
        System.out.println("Savings Account Number: " + accountNumber);

        // Access protected accountHolder directly
        System.out.println("Savings Account Holder: " + accountHolder);

        // Access private balance via public getter
        System.out.println("Balance: $" + getBalance());

        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for BankAccount
        System.out.println("Enter account number, account holder name, and balance:");
        int accNum = sc.nextInt();
        sc.nextLine(); // consume newline
        String holder = sc.nextLine();
        double bal = sc.nextDouble();
        sc.nextLine(); // consume newline

        BankAccount account = new BankAccount(accNum, holder, bal);
        System.out.println("\n--- Bank Account Details ---");
        account.displayAccountDetails();

        // Input for SavingsAccount
        System.out.println("\nEnter account number, account holder name, balance, and interest rate for savings account:");
        int savAccNum = sc.nextInt();
        sc.nextLine(); // consume newline
        String savHolder = sc.nextLine();
        double savBal = sc.nextDouble();
        sc.nextLine(); // consume newline
        double interest = sc.nextDouble();
        sc.nextLine(); // consume newline

        SavingsAccount savings = new SavingsAccount(savAccNum, savHolder, savBal, interest);
        System.out.println("\n--- Savings Account Details ---");
        savings.displaySavingsDetails();

        sc.close();
    }
}
