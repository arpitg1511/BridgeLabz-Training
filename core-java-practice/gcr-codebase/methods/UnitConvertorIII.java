import java.util.*;

public class UnitConvertorTemperature {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double fahrenheit = sc.nextDouble();
        System.out.println(fahrenheit + "°F = " + convertFahrenheitToCelsius(fahrenheit) + "°C");

        double celsius = sc.nextDouble();
        System.out.println(celsius + "°C = " + convertCelsiusToFahrenheit(celsius) + "°F");

        sc.close();
    }
}
