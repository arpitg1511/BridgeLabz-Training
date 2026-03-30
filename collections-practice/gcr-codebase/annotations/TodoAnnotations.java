import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectFeatures {

    @Todo(task = "Implement login feature", assignedTo = "Arpit", priority = "HIGH")
    public void login() {
    }

    @Todo(task = "Add payment gateway", assignedTo = "Rahul")
    public void payment() {
    }

    public void completedFeature() {
    }
}

public class TodoAnnotations {

    public static void main(String[] args) {

        Method[] methods = ProjectFeatures.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method      : " + method.getName());
                System.out.println("Task        : " + todo.task());
                System.out.println("Assigned To : " + todo.assignedTo());
                System.out.println("Priority    : " + todo.priority());
                System.out.println("----------------------------");
            }
        }
    }
}
