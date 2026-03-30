package PaymentGatewayIntegration;

interface PaymentProcessor {

    void pay(double amount);

    // NEW feature added safely
    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " initiated (default process)");
    }
}

