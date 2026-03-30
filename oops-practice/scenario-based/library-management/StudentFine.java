package library_management_system;

public class StudentFine implements FineCalculator {

    public double calculateFine(int lateDays) {
        return lateDays * 2;
    }
}

