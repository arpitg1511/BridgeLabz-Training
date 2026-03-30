import java.util.*;

public class PatientIdPrinter {

    public static void main(String[] args) {

        List<Integer> patientIds = Arrays.asList(
                1012, 1035, 1089, 1104, 1150
        );

        // Method reference instead of lambda
        patientIds.forEach(System.out::println);
    }
}
