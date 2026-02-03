import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) {
        if (obj == null) return "null";

        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (!first) {
                    json.append(", ");
                }
                json.append("\"").append(field.getName()).append("\": ");

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

        json.append("}");
        return json.toString();
    }

    // Demo main method
    public static void main(String[] args) {
        class Person {
            private String name;
            private int age;
            private boolean active;

            public Person(String name, int age, boolean active) {
                this.name = name;
                this.age = age;
                this.active = active;
            }
        }

        Person person = new Person("Arpit", 22, true);
        String json = toJson(person);
        System.out.println(json);
    }
}
