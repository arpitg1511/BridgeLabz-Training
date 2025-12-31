import java.util.*;
public class MobilePhone {
	
	String brand;
	String model;
	double price;
	
	public MobilePhone(String brand, String model, double price) {
		
		this.brand = brand;
		this.model = model;
		this.price = price;
	
	}
	
	void display() {
		System.out.println("Brand of mobile: " + brand);
		System.out.println("Model of mobile: " + model);
		System.out.printf("Price of mobile: %.2f\n", price);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MobilePhone mp = new MobilePhone(sc.nextLine(), sc.next(), sc.nextDouble());
		
		mp.display();
		
		sc.close();
	}
}
