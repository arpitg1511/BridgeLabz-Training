package digital_wallet_system;

public class DigitalWalletApp {

    public static void main(String[] args) {

        User u1 = new User(1, "Arpit");
        User u2 = new User(2, "Rohit");

        Wallet w1 = new Wallet(101);
        Wallet w2 = new Wallet(102);

        WalletService service = new WalletService();

        TransferService bankTransfer = new BankTransfer();
        TransferService walletTransfer = new WalletTransfer();

        try {
            service.addMoney(w1, 5000);
            service.addMoney(w2, 2000);

            walletTransfer.transfer(w1, w2, 1000);
            bankTransfer.transfer(w2, w1, 500);

            service.withdrawMoney(w1, 2000);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTransaction History:");
        service.showTransactions();

        System.out.println("\nFinal Balances:");
        System.out.println("Wallet 1: " + w1.getBalance());
        System.out.println("Wallet 2: " + w2.getBalance());
    }
}

