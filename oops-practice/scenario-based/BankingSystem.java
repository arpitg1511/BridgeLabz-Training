
import java.util.*;

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Abstraction
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
}

// Base Account Class
abstract class Account implements BankService {

    private int accountNumber;
    private String holderName;
    protected double balance;
    private List<String> transactionLog = new ArrayList<>();

    Account(int accNo, String name, double initialBalance) {
        this.accountNumber = accNo;
        setHolderName(name);
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
        transactionLog.add("Account opened with balance Rs " + balance);
    }

    public String getHolderName() {
        return holderName;
    }

    private void setHolderName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        this.holderName = name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactionLog.add("Deposited Rs " + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
        transactionLog.add("Withdrawn Rs " + amount);
    }

    public void printStatement() {
        System.out.println("\nTransaction History for " + holderName);
        for (String log : transactionLog) {
            System.out.println("- " + log);
        }
        System.out.println("Current Balance: Rs " + balance);
    }
}

// Savings Account
class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 0.04;

    SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// Current Account
class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 0.01;

    CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }
}

// Bank Manager (CRUD + Transfer)
class BankManager {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.hashCode(), account);
    }

    public void transferFunds(Account from, Account to, double amount)
            throws InsufficientBalanceException {

        from.withdraw(amount);
        to.deposit(amount);
    }
}

// Main Class
public class BankingSystem {

    public static void main(String[] args) {

        BankManager bank = new BankManager();

        Account savings = new SavingsAccount(101, "Rohit", 5000);
        Account current = new CurrentAccount(201, "Ankit", 8000);

        bank.createAccount(savings);
        bank.createAccount(current);

        try {
            savings.deposit(2000);
            savings.withdraw(1500);

            bank.transferFunds(savings, current, 1000);

            System.out.println("Savings Interest: Rs " + savings.calculateInterest());
            System.out.println("Current Interest: Rs " + current.calculateInterest());

        } catch (InsufficientBalanceException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        savings.printStatement();
        current.printStatement();
    }
}
