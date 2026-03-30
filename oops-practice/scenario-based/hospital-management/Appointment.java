package hospital_management_system;

public class Appointment {

    private final int appointmentId;
    private Patient patient;
    Doctor doctor;
    private String date;

    Appointment(int id, Patient patient, Doctor doctor, String date) {
        this.appointmentId = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    void display() {
        System.out.println(
            "Appointment ID: " + appointmentId +
            " Patient: " + patient.getName() +
            " Doctor: " + doctor.getName() +
            " Fee: ₹" + doctor.consultationFee()
        );
    }
}

