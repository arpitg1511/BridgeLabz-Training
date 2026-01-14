package digital_wallet_system;

import java.util.*;

public class WalletService {

    private List<Transaction> transactions = new ArrayList<>();

    void addMoney(Wallet wallet, double amount) {
        wallet.addMoney(amount);
        transactions.add(new Transaction("Added", amount));
    }

    void withdrawMoney(Wallet wallet, double amount)
            throws InsufficientBalanceException {

        wallet.withdraw(amount);
        transactions.add(new Transaction("Withdrawn", amount));
    }

    void showTransactions() {
        for (Transaction t : transactions) {
            t.display();
        }
    }
}

