package PaymentGatewayIntegration;

class UpiPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CreditCardPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class WalletPayment implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " credited to Wallet instantly");
    }
}
