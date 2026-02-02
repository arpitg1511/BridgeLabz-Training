import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfoReflection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the full class name (e.g., java.util.ArrayList):");
        String className = sc.nextLine();

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Print class name
            System.out.println("\nClass Name: " + clazz.getName());

            // Print all fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("No fields found.");
            } else {
                for (Field field : fields) {
                    System.out.println(" - " + field.getType().getSimpleName() + " " + field.getName());
                }
            }

            // Print all methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("No methods found.");
            } else {
                for (Method method : methods) {
                    System.out.print(" - " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
                    Class<?>[] params = method.getParameterTypes();
                    for (int i = 0; i < params.length; i++) {
                        System.out.print(params[i].getSimpleName());
                        if (i < params.length - 1) System.out.print(", ");
                    }
                    System.out.println(")");
                }
            }

            // Print all constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                System.out.println("No constructors found.");
            } else {
                for (Constructor<?> constructor : constructors) {
                    System.out.print(" - " + constructor.getName() + "(");
                    Class<?>[] params = constructor.getParameterTypes();
                    for (int i = 0; i < params.length; i++) {
                        System.out.print(params[i].getSimpleName());
                        if (i < params.length - 1) System.out.print(", ");
                    }
                    System.out.println(")");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }

        sc.close();
    }
}
