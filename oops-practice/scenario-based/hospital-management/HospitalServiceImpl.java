package hospital_management_system;

import java.util.*;

public class HospitalServiceImpl implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private int appointmentCounter = 1;

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    @Override
    public void removePatient(int patientId) {
        patients.removeIf(p -> p.getId() == patientId);
        System.out.println("Patient removed");
    }

    @Override
    public Appointment bookAppointment(
            Patient patient,
            Doctor doctor,
            String date
    ) throws AppointmentNotAvailableException {

        for (Appointment a : appointments) {
            if (a != null && a.doctor == doctor) {
                throw new AppointmentNotAvailableException("Doctor not available");
            }
        }

        Appointment appointment =
                new Appointment(appointmentCounter++, patient, doctor, date);

        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void cancelAppointment(int appointmentId) {
        appointments.removeIf(a -> a != null && appointmentId == appointmentId);
        System.out.println("Appointment cancelled");
    }

    void showAppointments() {
        for (Appointment a : appointments) {
            a.display();
        }
    }
}

