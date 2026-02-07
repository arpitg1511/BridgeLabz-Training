import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }
}

public class DoctorAvailability {

    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Sharma", "Cardiology", true),
                new Doctor("Dr. Mehta", "Orthopedics", false),
                new Doctor("Dr. Khan", "Dermatology", true),
                new Doctor("Dr. Verma", "Neurology", true)
        );

        doctors.stream()
               .filter(d -> d.availableOnWeekend)
               .sorted((d1, d2) -> d1.specialty.compareTo(d2.specialty))
               .forEach(d ->
                   System.out.println(d.name + " - " + d.specialty)
               );

    }
}
