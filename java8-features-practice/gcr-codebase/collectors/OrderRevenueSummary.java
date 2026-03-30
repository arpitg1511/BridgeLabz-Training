import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

class Order {
	String customerName;
	double value;
	
	public Order(String customerName, double value) {
		// TODO Auto-generated constructor stub
		this.customerName = customerName;
		this.value = value;
	}
}
public class OrderRevenueSummary {
	
	public static void main(String[] args) {
		
		List<Order> orders = Arrays.asList(
				new Order("Govind", 1200),
				new Order("Arpit", 134.76),
				new Order("Bhuvi", 14.23),
				new Order("Manish", 1630),
				new Order("Govind", 176.34),
				new Order("Aman", 1300),
				new Order("Bhuvi", 1100.432)
				);
		
		Map<String, Double> mp = orders.stream()
				.collect(Collectors.groupingBy(
						o -> o.customerName,
						Collectors.summingDouble(c -> c.value)
				));
		
		mp.forEach((name, value) ->
		System.out.println(name + " ----> " + value)
		);
	}
}
