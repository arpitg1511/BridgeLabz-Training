package digital_wallet_system;

public class Transaction {

    private String type;
    private double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    void display() {
        System.out.println(type + " : ₹" + amount);
    }
}

