import java.util.*;
public class UniversityDiscountCalculatedAsInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double fee = sc.nextDouble();
		double discountPercentage = sc.nextDouble();
		double discountProvided = ((fee * discountPercentage) / 100);
		System.out.println("The discount amount is INR " +
		discountProvided + " and final discounted fee is INR " +
				(fee - discountProvided));
	}
}
