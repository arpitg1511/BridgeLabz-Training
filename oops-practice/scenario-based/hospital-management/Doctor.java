package hospital_management_system;

public class Doctor extends Person {

    private String specialization;

    Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    double consultationFee() {
        return 500;
    }

    String getSpecialization() {
        return specialization;
    }
}

