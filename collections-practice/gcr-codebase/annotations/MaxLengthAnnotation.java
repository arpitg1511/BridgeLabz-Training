import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

// User class with validation in constructor
class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(this);
                    if (value instanceof String) {
                        String str = (String) value;
                        if (str.length() > maxLength.value()) {
                            throw new IllegalArgumentException(
                                    field.getName() + " exceeds max length of " + maxLength.value()
                            );
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "User{username='" + username + "'}";
    }
}

// Demo main method
public class MaxLengthAnnotation {

    public static void main(String[] args) {
        User validUser = new User("Arpit"); // valid
        System.out.println(validUser);

        // Uncommenting the following line will throw exception
        // User invalidUser = new User("VeryLongUsername"); // invalid
    }
}
