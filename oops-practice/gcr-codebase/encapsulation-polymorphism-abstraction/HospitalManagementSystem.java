// interface for medical record related operations
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// abstract base class for all patients
abstract class Patient implements MedicalRecord {

    private final String patientId;
    private String name;
    private int age;

    // sensitive medical data (encapsulated)
    private String diagnosis;
    private String medicalHistory;

    // constructor
    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // abstract method
    abstract double calculateBill();

    // concrete method
    void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
    }

    // controlled access to sensitive data
    void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }
}

// inpatient
class InPatient extends Patient {

    private int daysAdmitted;
    private double dailyCharge;

    InPatient(String id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        setMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Medical History: " + getMedicalHistory());
    }
}

// outpatient
class OutPatient extends Patient {

    private double consultationFee;

    OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        setMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Medical History: " + getMedicalHistory());
    }
}

// main class
public class HospitalManagementSystem {

    // polymorphic method (same pattern as earlier systems)
    static void printPatientBill(Patient p) {

        p.getPatientDetails();
        System.out.println("Total Bill : " + p.calculateBill());
        p.viewRecords();
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        Patient in = new InPatient("P101", "Amit", 45, 5, 3000);
        Patient out = new OutPatient("P202", "Neha", 30, 800);

        in.addRecord("Admitted for surgery");
        out.addRecord("Routine health checkup");

        printPatientBill(in);
        printPatientBill(out);
    }
}
