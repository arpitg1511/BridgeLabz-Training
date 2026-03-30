package library_management_system;

public class StaffFine implements FineCalculator {

    public double calculateFine(int lateDays) {
        return lateDays * 5;
    }
}

