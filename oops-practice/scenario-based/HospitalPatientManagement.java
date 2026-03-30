// Interface for abstraction
interface IPayable {
    double calculateBill();
}

// Base Patient class
class Patient {

    private final int patientId;
    private String patientName;
    private final String ailment;
    private String inDate;
    private String outDate;
    private final int billId;

    Patient(int patientId, String patientName, String ailment,
            String inDate, String outDate, int billId) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.ailment = ailment;
        this.inDate = inDate;
        this.outDate = outDate;
        this.billId = billId;
    }

    void displayInfo() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Patient Name : " + patientName);
        System.out.println("Ailment : " + ailment);
        System.out.println("In Date : " + inDate);
        System.out.println("Out Date : " + outDate);
        System.out.println("Bill ID : " + billId);
    }
}

// InPatient class
class InPatient extends Patient implements IPayable {

    private int daysAdmitted;
    private double chargePerDay;

    InPatient(int patientId, String patientName, String ailment,
              String inDate, String outDate, int billId,
              int daysAdmitted, double chargePerDay) {

        super(patientId, patientName, ailment, inDate, outDate, billId);
        this.daysAdmitted = daysAdmitted;
        this.chargePerDay = chargePerDay;
    }

    public double calculateBill() {
        return daysAdmitted * chargePerDay;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Type : InPatient");
        System.out.println("Total Bill : " + calculateBill());
    }
}

// OutPatient class
class OutPatient extends Patient implements IPayable {

    private double consultationFee;

    OutPatient(int patientId, String patientName, String ailment,
               String inDate, String outDate, int billId,
               double consultationFee) {

        super(patientId, patientName, ailment, inDate, outDate, billId);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Patient Type : OutPatient");
        System.out.println("Total Bill : " + calculateBill());
    }
}

// Doctor class
class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;

    Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    void displayDoctorInfo() {
        System.out.println("Doctor ID : " + doctorId);
        System.out.println("Doctor Name : " + doctorName);
        System.out.println("Specialization : " + specialization);
    }
}

// MAIN CLASS (ONLY THIS IS PUBLIC)
public class HospitalPatientManagement {

    public static void main(String[] args) {

        Doctor doctor = new Doctor(1, "Dr. Verma", "Physician");

        Patient p1 = new InPatient(
                101, "Rahul", "Fever",
                "01-01-2026", "05-01-2026",
                1001, 4, 1500
        );

        Patient p2 = new OutPatient(
                102, "Aman", "Cold",
                "02-01-2026", "02-01-2026",
                1002, 400
        );

        doctor.displayDoctorInfo();
        System.out.println("----------------");

        p1.displayInfo();
        System.out.println("----------------");

        p2.displayInfo();
    }
}
