package aerovigil;

import java.util.HashMap;
import java.util.Map;

class FlightUtil {

	private static final String FLIGHT_PATTERN = "^FL-[1-9][0-9]{3}$";

	private static final Map<String, Integer> PASSENGER_CAPACITY = new HashMap<>();
	private static final Map<String, Integer> FUEL_CAPACITY = new HashMap<>();

	static {
		PASSENGER_CAPACITY.put("SPICEJET", 396);
		PASSENGER_CAPACITY.put("VISTARA", 615);
		PASSENGER_CAPACITY.put("INDIGO", 230);
		PASSENGER_CAPACITY.put("AIR ARABIA", 130);

		FUEL_CAPACITY.put("SPICEJET", 200000);
		FUEL_CAPACITY.put("VISTARA", 300000);
		FUEL_CAPACITY.put("INDIGO", 250000);
		FUEL_CAPACITY.put("AIR ARABIA", 150000);
	}

	public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
		if (flightNumber == null || !flightNumber.matches(FLIGHT_PATTERN)) {
			throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
		}
		return true;
	}

	public boolean validateFlightName(String flightName) throws InvalidFlightException {
		if (flightName == null || !PASSENGER_CAPACITY.containsKey(flightName.toUpperCase())) {
			throw new InvalidFlightException("The flight name " + flightName + " is invalid");
		}
		return true;
	}

	public boolean validatePassengerCount(int passengerCount, String flightName)
			throws InvalidFlightException {

		String key = flightName.toUpperCase();
		int maxAllowed = PASSENGER_CAPACITY.get(key);

		if (passengerCount <= 0 || passengerCount > maxAllowed) {
			throw new InvalidFlightException(
					"The passenger count " + passengerCount + " is invalid for " + flightName);
		}
		return true;
	}

	public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
			throws InvalidFlightException {

		String key = flightName.toUpperCase();
		int maxFuel = FUEL_CAPACITY.get(key);

		if (currentFuelLevel <= 0 || currentFuelLevel > maxFuel) {
			throw new InvalidFlightException("Invalid fuel level for " + flightName);
		}
		return maxFuel - currentFuelLevel;
	}
}