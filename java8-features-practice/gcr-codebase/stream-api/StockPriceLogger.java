import java.util.Arrays;
import java.util.List;

class Stock {
	
	String stockName;
	double stockPrice;
	
	Stock(String stockName, double stockPrice) {
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}
	
	@Override
	public String toString() {
		return stockName + " price is " + stockPrice;
	}
}
public class StockPriceLogger {
	public static void main(String[] args) {
		List<Stock> list = Arrays.asList(
				new Stock("S1", 100.00),
				new Stock("S2", 120.43),
				new Stock("S3", 23.12),
				new Stock("S4", 124.3));
		
		list.stream()
		.forEach(s -> System.out.println(s));
	}
}
