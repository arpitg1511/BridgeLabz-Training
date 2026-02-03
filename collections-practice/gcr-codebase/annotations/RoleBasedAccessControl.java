import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value(); // role name
}

// Simulated user context
class UserContext {
    private String role;

    public UserContext(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// Service class with role-based methods
class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed successfully!");
    }

    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("User task performed successfully!");
    }
}

// Access control handler
public class RoleBasedAccessControl {

    public static void invokeIfAllowed(Object obj, String methodName, UserContext user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(user.getRole())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                // No annotation = allow by default
                method.invoke(obj);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Demo main method
    public static void main(String[] args) {
        AdminService service = new AdminService();

        UserContext adminUser = new UserContext("ADMIN");
        UserContext normalUser = new UserContext("USER");

        System.out.println("Admin trying to perform admin task:");
        invokeIfAllowed(service, "performAdminTask", adminUser); // Allowed

        System.out.println("\nUser trying to perform admin task:");
        invokeIfAllowed(service, "performAdminTask", normalUser); // Denied

        System.out.println("\nUser performing user task:");
        invokeIfAllowed(service, "performUserTask", normalUser); // Allowed
    }
}
