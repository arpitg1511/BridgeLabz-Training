
public class LicensePlateValidator {

    private static final String PLATE_REGEX = "^[A-Z]{2}\\d{4}$";

    public static boolean isValid(String plateNumber) {
        return plateNumber != null && plateNumber.matches(PLATE_REGEX);
    }

    public static void main(String[] args) {
        System.out.println("AB1234 -> " + isValid("AB1234")); // true
        System.out.println("A12345 -> " + isValid("A12345")); // false
    }
}

