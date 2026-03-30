
public class HexColorValidator {

    private static final String HEX_REGEX = "^#[0-9A-Fa-f]{6}$";

    public static boolean isValid(String color) {
        return color != null && color.matches(HEX_REGEX);
    }

    public static void main(String[] args) {
        System.out.println("#FFA500 -> " + isValid("#FFA500")); // true
        System.out.println("#123 -> " + isValid("#123"));       // false
    }
}
