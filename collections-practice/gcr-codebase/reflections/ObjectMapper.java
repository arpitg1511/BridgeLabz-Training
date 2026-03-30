import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance using the no-arg constructor
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // allow access to private fields
                    field.set(obj, value);
                } catch (NoSuchFieldException e) {
                    // Ignore fields that don't exist in the class
                }
            }

            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Failed to map object", e);
        }
    }

    // Demo main method
    public static void main(String[] args) {
        // Example class
        class Person {
            private String name;
            private int age;

            @Override
            public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
            }
        }

        // Map with values
        Map<String, Object> props = Map.of(
                "name", "Arpit",
                "age", 22
        );

        Person person = toObject(Person.class, props);
        System.out.println(person); // Person{name='Arpit', age=22}
    }
}
