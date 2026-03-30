import java.util.*;

// Base class representing a generic bank account
class BankAccount {

    // Final account number cannot be changed once assigned
    final int accountNumber;
    double balance;

    // Constructor to initialize common account details
    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display account type (to be overridden by subclasses)
    void displayAccountType() {
        System.out.println("Just Bank Account");
    }
}

// SavingsAccount inherits from BankAccount
class SavingsAccount extends BankAccount {

    double interestRate;

    // Constructor initializes both parent and savings-specific details
    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // initialize BankAccount data
        this.interestRate = interestRate;
    }

    // Overridden method to display savings account type
    @Override
    void displayAccountType() {
        System.out.println("Savings Account");
    }
}

// CheckingAccount inherits from BankAccount
class CheckingAccount extends BankAccount {

    double withdrawalLimit;
    double interestRate;

    // Constructor initializes parent and checking-specific details
    public CheckingAccount(int accountNumber, double balance,
                           double interestRate, double withdrawLimit) {
        super(accountNumber, balance); // initialize BankAccount data
        this.interestRate = interestRate;
        this.withdrawalLimit = withdrawLimit;
    }

    // Overridden method to display checking account type
    @Override
    void displayAccountType() {
        System.out.println("Checking Account");
    }
}

// FixedDepositAccount inherits from BankAccount
class FixedDepositAccount extends BankAccount {

    String maturity;
    double interestRate;

    // Constructor initializes parent and fixed deposit details
    public FixedDepositAccount(int accountNumber, double balance,
                               double interestRate, String maturity) {
        super(accountNumber, balance); // initialize BankAccount data
        this.interestRate = interestRate;
        this.maturity = maturity;
    }

    // Overridden method to display fixed deposit account type
    @Override
    void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
}

public class BankingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating different account objects using parent class reference
        BankAccount ac =
                new BankAccount(sc.nextInt(), sc.nextDouble());

        BankAccount sac =
                new SavingsAccount(sc.nextInt(), sc.nextDouble(), sc.nextDouble());

        BankAccount cac =
                new CheckingAccount(sc.nextInt(), sc.nextDouble(),
                                    sc.nextDouble(), sc.nextDouble());

        BankAccount fac =
                new FixedDepositAccount(sc.nextInt(), sc.nextDouble(),
                                        sc.nextDouble(), sc.next());

        // Method calls resolved at runtime (Dynamic Method Dispatch)
        ac.displayAccountType();
        sac.displayAccountType();
        cac.displayAccountType();
        fac.displayAccountType();

        sc.close();
    }
}
