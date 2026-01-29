import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelBooking {
	
	private static List<String> HOTELS = Arrays.asList("ABC", "PQR", "XYZ");
	private static List<String> ROOMS = Arrays.asList("Standard", "Deluxe", "Suite");
	
	private static final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$");
	
	public static void validateUserDetails(int age, String email, String creditCardNumber) 
			throws InvalidBookingDetailsException {
		
		if(age < 18 || age > 100) 
			throw new InvalidBookingDetailsException("Invalid Age");
		
		if(!creditCardNumber.matches("\\d{16}")) 
			throw new InvalidBookingDetailsException("Invalid Credit Card Number");
		
		Matcher emailMatcher = emailPattern.matcher(email);
		if(!emailMatcher.matches()) 
			throw new InvalidBookingDetailsException("Invalid email address");
	}
	
	public static void validateBookingDetails(String hotelName, String roomType, String checkInDate, String checkOutDate)
		throws InvalidBookingDetailsException {
		
		if(!HOTELS.contains(hotelName))
			throw new InvalidBookingDetailsException("Invalid Hotel Name");
		
		if(!ROOMS.contains(roomType))
			throw new InvalidBookingDetailsException("Invalid type of room");
		
		LocalDate checkIn;
		LocalDate checkOut;
		
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			checkIn = LocalDate.parse(checkInDate, format);
			checkOut = LocalDate.parse(checkOutDate, format);
		} catch(Exception e) {
			throw new InvalidBookingDetailsException("Invalid Date Format");
		}
		
		if(checkIn.isAfter(checkOut) || !checkIn.isAfter(LocalDate.now()))
			throw new InvalidBookingDetailsException("Invalid Check In  or Check Out Date");
	}
	
	static int calculateBookingCost(String roomType, int numNights, boolean isBreakfastIncluded) {
		
		int cost = 0;
		if(roomType.equals("Standard")) cost = 1000;
		else if(roomType.equals("Deluxe")) cost = 2000;
		else if(roomType.equals("Suite")) cost = 3000;
		
		int breakfastCost = 100;
		cost += isBreakfastIncluded ? breakfastCost : 0;
		
		return cost * numNights;
	}
}