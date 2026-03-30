interface UnitConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }
}

public class LogisticsConversionTool {

    public static void main(String[] args) {

        double distanceKm = 100;
        double weightKg = 50;

        System.out.println("Distance in miles: " +
                UnitConverter.kmToMiles(distanceKm));

        System.out.println("Weight in pounds: " +
                UnitConverter.kgToPounds(weightKg));
    }
}
