import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

// User class with annotated fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; // not annotated, should be ignored

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

// JSON serializer
public class JsonSerializer {

    public static String toJson(Object obj) {
        if (obj == null) return "null";

        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (!first) {
                        json.append(", ");
                    }
                    json.append("\"").append(jsonField.name()).append("\": ");
                    if (value == null) {
                        json.append("null");
                    } else if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    first = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append("}");
        return json.toString();
    }

    // Demo main method
    public static void main(String[] args) {
        User user = new User("Arpit", 22, "secret123");
        String json = toJson(user);
        System.out.println(json);
    }
}
