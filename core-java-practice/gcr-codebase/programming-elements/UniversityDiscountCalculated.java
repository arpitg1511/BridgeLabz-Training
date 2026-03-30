
public class UniversityDiscountCalculated {
	public static void main(String[] args) {
		int fee = 125000;
		int discountPercentage = 10;
		double discountProvided = ((fee * discountPercentage) / 100);
		System.out.println("The discount amount is INR " +
		discountProvided + " and final discounted fee is INR " +
				(fee - discountProvided));
	}
}
