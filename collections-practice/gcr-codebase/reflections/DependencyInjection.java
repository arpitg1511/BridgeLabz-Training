import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// 1️⃣ Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

// 2️⃣ Service classes
class ServiceA {
    public void sayHello() {
        System.out.println("Hello from ServiceA");
    }
}

class ServiceB {
    @Inject
    private ServiceA serviceA;

    public void greet() {
        serviceA.sayHello();
        System.out.println("ServiceB greets you!");
    }
}

// 3️⃣ Simple DI container + demo
public class DependencyInjection {

    public static <T> T createInstance(Class<T> clazz) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Inject dependencies
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Object dependency = createInstance(field.getType());
                    field.set(instance, dependency);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance for " + clazz.getName(), e);
        }
    }

    public static void main(String[] args) {
        ServiceB serviceB = createInstance(ServiceB.class);
        serviceB.greet();
    }
}
