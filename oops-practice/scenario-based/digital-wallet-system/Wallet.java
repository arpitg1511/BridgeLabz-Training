package digital_wallet_system;

public class Wallet {

    private final int walletId;
    private double balance;

    Wallet(int id) {
        this.walletId = id;
        this.balance = 0;
    }

    double getBalance() {
        return balance;
    }

    void addMoney(double amount) {
        balance += amount;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }
}

