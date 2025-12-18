import java.util.*;
public class DistanceInYardsAndMiles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double feet = sc.nextDouble();
		double yard = feet / 3;
		double miles = yard / 1760;
		System.out.println("Distance in feet is " + feet +
				" , distance in yards is " + yard + " and distance in miles is" + miles);
	}
}
