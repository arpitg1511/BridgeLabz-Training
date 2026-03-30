package hospital_management_system;

public class SpecialistDoctor extends Doctor {

    SpecialistDoctor(int id, String name, String specialization) {
        super(id, name, specialization);
    }

    @Override
    double consultationFee() {
        return 1000;
    }
}
