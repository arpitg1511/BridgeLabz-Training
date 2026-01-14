package ecommerce;
public class UPI implements Payment{
	
	public void pay(double amount) throws PaymentFailedException {
		
		if(amount > 100000) throw new PaymentFailedException("UPI failed");
		
		System.out.println(amount + " paid using UPI");
	}
}
