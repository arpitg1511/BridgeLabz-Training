package hospital_management_system;

public class HospitalApp {

    public static void main(String[] args) {

        HospitalServiceImpl service = new HospitalServiceImpl();

        Patient p1 = new Patient(1, "Rohit");
        p1.addMedicalRecord("Diabetes");

        Doctor d1 = new Doctor(101, "Dr. Sharma", "General");
        Doctor d2 = new SpecialistDoctor(102, "Dr. Mehta", "Cardiology");

        service.addPatient(p1);

        try {
            Appointment a1 =
                service.bookAppointment(p1, d1, "15-Jan-2026");
            a1.display();

            Appointment a2 =
                service.bookAppointment(p1, d2, "16-Jan-2026");
            a2.display();

        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.viewMedicalHistory();
        service.showAppointments();
    }
}

