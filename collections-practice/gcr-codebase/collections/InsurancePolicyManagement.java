import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagement {

    static class Policy {
        String number;
        String name;
        LocalDate expiry;
        String type;
        double premium;

        Policy(String number, String name, LocalDate expiry,
               String type, double premium) {
            this.number = number;
            this.name = name;
            this.expiry = expiry;
            this.type = type;
            this.premium = premium;
        }

        // Policies are considered same if policy number is same
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Policy p = (Policy) obj;
            return number.equals(p.number);
        }

        @Override
        public int hashCode() {
            return number.hashCode();
        }

        @Override
        public String toString() {
            return number + " - " + name + " - " + type + " - " + expiry;
        }
    }

    static Set<Policy> policySet = new HashSet<>();

    static void addPolicy(Policy p) {
        policySet.add(p);
    }

    static void printAllPolicies() {
        for (Policy p : policySet) {
            System.out.println(p);
        }
    }

    static void showExpiringSoon() {
        LocalDate today = LocalDate.now();

        for (Policy p : policySet) {
            if (p.expiry.isAfter(today) &&
                p.expiry.isBefore(today.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    static void filterByType(String requiredType) {
        for (Policy p : policySet) {
            if (p.type.equalsIgnoreCase(requiredType)) {
                System.out.println(p);
            }
        }
    }

    static void showSortedByExpiry() {
        TreeSet<Policy> sortedSet = new TreeSet<>(
            Comparator.comparing(a -> a.expiry)
        );

        sortedSet.addAll(policySet);

        for (Policy p : sortedSet) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        addPolicy(new Policy("P201", "Ravi",
                LocalDate.now().plusDays(12), "Health", 4500));

        addPolicy(new Policy("P202", "Neha",
                LocalDate.now().plusDays(50), "Auto", 7200));

        addPolicy(new Policy("P203", "Aman",
                LocalDate.now().plusDays(20), "Health", 6100));

        System.out.println("All Policies:");
        printAllPolicies();

        System.out.println("\nExpiring within 30 days:");
        showExpiringSoon();

        System.out.println("\nHealth Insurance Policies:");
        filterByType("Health");

        System.out.println("\nPolicies sorted by expiry date:");
        showSortedByExpiry();
    }
}
