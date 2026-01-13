package ecommerce;

public class CardPayment implements Payment{
	
	public void pay(double amount) throws PaymentFailedException {
		
		if(amount <= 0) {
			throw new PaymentFailedException("Card Payment Invalid");
		}
		
		System.out.println(amount +"Paid using card");
	}
}
