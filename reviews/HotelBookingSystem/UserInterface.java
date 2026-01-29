import java.util.*;
import java.time.*;

public class UserInterface {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter your Name : ");
			String name = sc.nextLine();
			
			System.out.println("Enter age : ");
			int age = sc.nextInt();
			
			System.out.println("Enter email address : ");
			String email = sc.next();
			
			System.out.println("Enter credit card number : ");
			String creditCardNumber = sc.next();
			
			HotelBooking.validateUserDetails(age, email, creditCardNumber);
			
			sc.nextLine();
			System.out.println("Enter Hotel Name : ");
			String hotelName = sc.nextLine();
			
			System.out.println("Enter Room Type : ");
			String roomType = sc.nextLine();
			
			System.out.println("Enter check in date : ");
			String checkInDate = sc.next();
			
			System.out.println("Enter check out date : ");
			String checkOutDate = sc.next();
			
			HotelBooking.validateBookingDetails(hotelName, roomType, checkInDate, checkOutDate);
			
			int numNights = LocalDate.parse(checkOutDate)
	        .compareTo(LocalDate.parse(checkInDate));
			
			System.out.println("Select if breakfast is included (Y/N) : ");
			String breakfast = sc.next();
			
			boolean breakfastIncluded = false;
			
			if(breakfast.equalsIgnoreCase("y")) breakfastIncluded = true;
			
			int totalBillAmount = HotelBooking.calculateBookingCost(roomType, numNights, breakfastIncluded);
			
			System.out.println("Total Bill Amount : ₹ " + totalBillAmount);
			
		} catch(InvalidBookingDetailsException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
