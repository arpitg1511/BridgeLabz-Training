import java.util.Date;

class BankAccount {

    private int balance = 10000;

    // Try commenting 'synchronized' to observe race condition
    public synchronized boolean withdraw(String customerName, int amount) {

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println("Transaction successful: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + new Date());

            return true;
        } else {
            System.out.println("Transaction failed: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + new Date());
            return false;
        }
    }
}

class Transaction implements Runnable {

    private BankAccount account;
    private String customerName;
    private int amount;

    public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println(customerName + " - Thread State before execution: "
                + Thread.currentThread().getState());

        account.withdraw(customerName, amount);
    }
}

public class BankingSystem {

    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("All transactions processed.");
    }
}
