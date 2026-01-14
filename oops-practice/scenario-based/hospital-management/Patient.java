package hospital_management_system;

import java.util.*;

public class Patient extends Person {

    private List<String> medicalHistory = new ArrayList<>();

    Patient(int id, String name) {
        super(id, name);
    }

    void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    void viewMedicalHistory() {
        for (String record : medicalHistory) {
            System.out.println(record);
        }
    }
}

