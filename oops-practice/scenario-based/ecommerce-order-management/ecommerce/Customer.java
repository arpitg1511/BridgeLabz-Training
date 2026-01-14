package ecommerce;

public class Customer {
	
	private final int customerId;
	private String customerName;
	
	public Customer(int id, String name) {
		this.customerId = id;
		this.customerName = name;
	}
	
	int getId() {
		return customerId;
	}
	
	String getName() {
		return customerName;
	}
	
	void displayCustomer() {
        System.out.println(customerId + " " + customerName);
    }
}
