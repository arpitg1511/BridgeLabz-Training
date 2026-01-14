package ecommerce;

public class Product {
	private final int productID;
	private String productName;
	private double price;
	
	Product(int id, String name, double price) {
		this.productID = id;
		this.productName = name;
		this.price = price;
	}
	
	int getID() {
		return productID;
	}
	
	String getName() {
		return productName;
	}
	
	double getPrice() {
		return price;
	}
	
	void displayProduct() {
        System.out.println(productID + " " + productName + " ₹" + price);
    }
}
