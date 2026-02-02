import java.lang.annotation.*;
import java.lang.reflect.*;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD) // Can be applied to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with default value
}

// Step 2: Example class with some methods
class MyClass {

    @ImportantMethod // Uses default level "HIGH"
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM") // Custom level
    public void secondaryTask() {
        System.out.println("Executing secondary task...");
    }

    public void normalTask() {
        System.out.println("Executing normal task...");
    }
}

// Step 3: Main class to retrieve annotated methods
public class ImportantAnnotations {
    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;

        System.out.println("Important methods in MyClass:");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}
