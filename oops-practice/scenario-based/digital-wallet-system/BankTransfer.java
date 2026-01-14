package digital_wallet_system;

public class BankTransfer implements TransferService {

    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdraw(amount);
        to.addMoney(amount);
        System.out.println("Transferred ₹" + amount + " via Bank");
    }
}

