// Marker interface for backup eligibility
interface BackupSerializable {
    // no methods
}

// Class marked for backup
class EmployeeData implements BackupSerializable {
    int empId;
    String empName;

    EmployeeData(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }
}

// Class NOT marked for backup
class TemporaryLog {
    String message;

    TemporaryLog(String message) {
        this.message = message;
    }
}

public class BackupProcessor {

    // Method that checks marker interface
    static void backup(Object obj) {

        if (obj instanceof BackupSerializable) {
            System.out.println("Object eligible for backup -> Serializing data");
        } else {
            System.out.println("Object NOT eligible for backup");
        }
    }

    public static void main(String[] args) {

        EmployeeData emp = new EmployeeData(101, "Arpit");
        TemporaryLog log = new TemporaryLog("Session started");

        backup(emp);
        backup(log);
    }
}
