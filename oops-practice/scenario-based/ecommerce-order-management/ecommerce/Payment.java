package ecommerce;

interface Payment {
	void pay(double amount) throws PaymentFailedException;
}
