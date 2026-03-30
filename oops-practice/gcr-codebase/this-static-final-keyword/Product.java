import java.util.*;

public class Product {

	// Shared discount for all products
	static double discount = 10.0;

	static void updateDiscount(double newDiscount) {
		discount = newDiscount;
	}

	final int productID;
	String productName;
	double price;
	int quantity;

	// Constructor using this
	public Product(int productID, String productName, double price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	void displayProductDetails(Object obj) {
		if (!(obj instanceof Product)) {
			System.out.println("Invalid Product object");
			return;
		}

		double discountedPrice = price - (price * discount / 100);

		System.out.println("Product ID : " + productID);
		System.out.println("Product Name : " + productName);
		System.out.println("Price : " + price);
		System.out.println("Quantity : " + quantity);
		System.out.println("Discount : " + discount + "%");
		System.out.println("Price after discount : " + discountedPrice);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int id = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		double price = sc.nextDouble();
		int quantity = sc.nextInt();
		double newDiscount = sc.nextDouble();

		Product p = new Product(id, name, price, quantity);

		Product.updateDiscount(newDiscount);
		p.displayProductDetails(p);

		sc.close();
	}
}
