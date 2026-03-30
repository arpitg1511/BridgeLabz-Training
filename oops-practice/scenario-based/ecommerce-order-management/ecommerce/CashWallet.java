package ecommerce;

public class CashWallet implements Payment{

	public void pay(double amount) throws PaymentFailedException {
		if(amount >= 500000) {
			throw new PaymentFailedException("Can't take over cash limit");
		}
		
		System.out.println("Payment Recieved of amount " + amount);
	}
}
