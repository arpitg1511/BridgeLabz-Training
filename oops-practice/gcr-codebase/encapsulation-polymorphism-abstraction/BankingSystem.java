// interface for loan related operations
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

// abstract base class for all bank accounts
abstract class BankAccount implements Loanable {

    private final String accountNumber;
    private String holderName;
    protected double balance;

    // constructor
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // concrete methods
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // abstract method
    abstract double calculateInterest();

    // getters
    String getAccountNumber() {
        return accountNumber;
    }

    String getHolderName() {
        return holderName;
    }

    double getBalance() {
        return balance;
    }
}

// savings account
class SavingsAccount extends BankAccount {

    SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.04;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Savings Account Loan Applied");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}

// current account
class CurrentAccount extends BankAccount {

    CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    double calculateInterest() {
        return balance * 0.02;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Current Account Loan Applied");
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 10;
    }
}

// main class
public class BankingSystem {

    // polymorphic method (same like e-commerce final price method)
    static void printAccountDetails(BankAccount acc) {

        System.out.println("Account Number : " + acc.getAccountNumber());
        System.out.println("Holder Name    : " + acc.getHolderName());
        System.out.println("Balance        : " + acc.getBalance());
        System.out.println("Interest       : " + acc.calculateInterest());
        acc.applyForLoan();
        System.out.println("Loan Eligibility: " + acc.calculateLoanEligibility());
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        BankAccount s = new SavingsAccount("SB101", "Arpit", 50000);
        BankAccount c = new CurrentAccount("CA201", "Rahul", 100000);

        printAccountDetails(s);
        printAccountDetails(c);
    }
}
