
public class ProfitLoss {
	public static void main(String[] args) {
		int costPrice = 129;
		int sellPrice = 191;
		double profit = sellPrice - costPrice;
		System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellPrice +
				"\nThe Profit is INR " + (sellPrice- costPrice) + " and the profit percentage is " + ((profit * 100)/costPrice));
	}
}
