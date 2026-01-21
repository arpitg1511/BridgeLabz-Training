import java.util.ArrayList;
import java.util.List;

/* ---------- Job Role Hierarchy ---------- */

abstract class JobRole {
    public abstract String getRoleName();
    public abstract int getMinimumExperience();
}

class SoftwareEngineer extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }

    public int getMinimumExperience() {
        return 2;
    }
}

class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }

    public int getMinimumExperience() {
        return 3;
    }
}

class ProductManager extends JobRole {
    public String getRoleName() {
        return "Product Manager";
    }

    public int getMinimumExperience() {
        return 4;
    }
}

/* ---------- Generic Resume Class ---------- */

class Resume<T extends JobRole> {

    private final String candidateName;
    private final int yearsOfExperience;
    private final T role;

    public Resume(String candidateName, int yearsOfExperience, T role) {
        this.candidateName = candidateName;
        this.yearsOfExperience = yearsOfExperience;
        this.role = role;
    }

    public boolean isEligible() {
        return yearsOfExperience >= role.getMinimumExperience();
    }

    public T getRole() {
        return role;
    }

    public void displayResult() {
        System.out.println(
                candidateName + " | Role: " + role.getRoleName() +
                " | Experience: " + yearsOfExperience +
                " | Status: " + (isEligible() ? "Shortlisted" : "Rejected")
        );
    }
}

/* ---------- Screening Utility (Generic + Wildcards) ---------- */

class ResumeScreeningEngine {

    // Generic method
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        resume.displayResult();
    }

    // Wildcard method to handle multiple job roles
    public static void screenPipeline(List<? extends JobRole> roles) {
        System.out.println("\nScreening Pipeline Supports Roles:");
        for (JobRole role : roles) {
            System.out.println("- " + role.getRoleName());
        }
    }
}

/* ---------- Driver Class ---------- */

public class ResumeScreening {

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>("Amit", 3, new SoftwareEngineer());

        Resume<DataScientist> r2 =
                new Resume<>("Neha", 2, new DataScientist());

        Resume<ProductManager> r3 =
                new Resume<>("Rohit", 5, new ProductManager());

        ResumeScreeningEngine.screenResume(r1);
        ResumeScreeningEngine.screenResume(r2);
        ResumeScreeningEngine.screenResume(r3);

        List<JobRole> supportedRoles = new ArrayList<>();
        supportedRoles.add(new SoftwareEngineer());
        supportedRoles.add(new DataScientist());
        supportedRoles.add(new ProductManager());

        ResumeScreeningEngine.screenPipeline(supportedRoles);
    }
}
