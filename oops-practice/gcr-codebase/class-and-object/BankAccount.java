import java.util.*;
public class BankAccount {

    // Encapsulation: data members are private
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstraction: deposit logic hidden from user
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
        displayBalance();
    }

    // Abstraction: withdraw logic with validation
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to display current balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Getter method (Encapsulation)
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	// Safe input handling
        String name = sc.nextLine();
        int accNo = sc.nextInt();
        double bal = sc.nextDouble();
        
        BankAccount account =
                new BankAccount(name, accNo, bal);

        // Initial balance
        account.displayBalance();

        // Deposit operation
        account.deposit(200.0);

        // Withdraw operation
        account.withdraw(100.0);

        // Insufficient balance case
        account.withdraw(1000.0);
        
        sc.close();
    }
}
