package PaymentGatewayIntegration;

public class PaymentApp {

    public static void main(String[] args) {

        PaymentProcessor upi = new UpiPayment();
        PaymentProcessor card = new CreditCardPayment();
        PaymentProcessor wallet = new WalletPayment();

        upi.pay(500);
        upi.refund(500);

        card.pay(1000);
        card.refund(1000);

        wallet.pay(300);
        wallet.refund(300);
    }
}

