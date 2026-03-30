package aerovigil;

import java.util.*;

public class UserInterface {

	public static void main(String[] args) {

		FlightUtil util = new FlightUtil();

		System.out.println("Enter flight details");

		try (Scanner scanner = new Scanner(System.in)) {

			String[] input = scanner.nextLine().split(":");

			String flightNumber = input[0];
			String flightName = input[1];
			int passengerCount = Integer.parseInt(input[2]);
			double fuelLevel = Double.parseDouble(input[3]);

			util.validateFlightNumber(flightNumber);
			util.validateFlightName(flightName);
			util.validatePassengerCount(passengerCount, flightName);

			double fuelRequired = util.calculateFuelToFillTank(flightName, fuelLevel);

			System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

		} catch (InvalidFlightException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
