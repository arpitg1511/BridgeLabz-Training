import java.util.*;

public class HospitalTriage {

    static class Patient {
        String name;
        int severity;

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }
    }
    public static void main(String[] args) {

        // PriorityQueue with custom priority (higher severity first)
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (p1, p2) -> p2.severity - p1.severity
        );

        // Adding patients
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");

        while (!queue.isEmpty()) {
            Patient p = queue.remove();
            System.out.println(p.name);
        }
    }
}
