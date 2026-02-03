import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class AccessStaticField {

    public static void main(String[] args) throws Exception {

        Class<?> cls = Configuration.class;

        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);

        field.set(null, "NEW_API_KEY");

        String value = (String) field.get(null);

        System.out.println("API_KEY: " + value);
    }
}
