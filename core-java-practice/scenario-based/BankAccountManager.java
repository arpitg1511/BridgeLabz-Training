/* BankAccount class to manage account operations */
class BankAccount {

    // Account properties
    private String accountNumber;
    private double balance;

    // Constructor to initialize account details
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money with overdraft protection
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed. Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount: " + amount);
        }
    }

    // Method to check current balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

/* Main class to test BankAccount */
public class BankAccountManager {

    public static void main(String[] args) {

        // Create a bank account
        BankAccount account = new BankAccount("ACC12345", 5000);

        // Perform operations
        account.checkBalance();
        account.deposit(2000);
        account.withdraw(3000);
        account.withdraw(6000); // overdraft attempt
        account.checkBalance();
    }
}
