import java.util.*;

// Interface defining work-related behavior
interface Worker {

    // Method that must be implemented by all workers
    void performDuties();
}

// Base class representing a person in the restaurant
class RestaurantPerson {

    String name;
    int id;

    // Constructor to initialize common person details
    public RestaurantPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Chef class inherits from RestaurantPerson and implements Worker
class Chef extends RestaurantPerson implements Worker {

    String specialty;

    // Constructor initializes person and chef-specific details
    public Chef(String name, int id, String specialty) {
        super(name, id); // initialize RestaurantPerson data
        this.specialty = specialty;
    }

    // Implementation of Worker interface method
    @Override
    public void performDuties() {
        System.out.println("Chef Name : " + name);
        System.out.println("Specialty : " + specialty);
        System.out.println("Duties : Preparing and cooking food");
    }
}

// Waiter class inherits from RestaurantPerson and implements Worker
class Waiter extends RestaurantPerson implements Worker {

    int tableCount;

    // Constructor initializes person and waiter-specific details
    public Waiter(String name, int id, int tableCount) {
        super(name, id); // initialize RestaurantPerson data
        this.tableCount = tableCount;
    }

    // Implementation of Worker interface method
    @Override
    public void performDuties() {
        System.out.println("Waiter Name : " + name);
        System.out.println("Tables Assigned : " + tableCount);
        System.out.println("Duties : Taking orders and serving food");
    }
}

public class RestaurantSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating Chef object using interface reference
        Worker chef = new Chef(sc.nextLine(), sc.nextInt(), sc.next());

        // Creating Waiter object using interface reference
        Worker waiter = new Waiter(sc.nextLine(), sc.nextInt(), sc.nextInt());

        // Method calls resolved at runtime (Dynamic Method Dispatch)
        chef.performDuties();
        waiter.performDuties();

        sc.close();
    }
}
