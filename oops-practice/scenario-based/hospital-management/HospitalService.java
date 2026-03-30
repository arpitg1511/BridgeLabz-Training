package hospital_management_system;

public interface HospitalService {

    void addPatient(Patient patient);
    void removePatient(int patientId);

    Appointment bookAppointment(
        Patient patient,
        Doctor doctor,
        String date
    ) throws AppointmentNotAvailableException;

    void cancelAppointment(int appointmentId);
}

