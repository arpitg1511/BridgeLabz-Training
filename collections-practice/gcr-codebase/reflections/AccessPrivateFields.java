import java.lang.reflect.Field;

class Person {
    private int age;

    Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateFields {

    public static void main(String[] args) throws Exception {

        Person person = new Person(20);

        Class<?> cls = person.getClass();
        Field field = cls.getDeclaredField("age");

        field.setAccessible(true);

        field.set(person, 25);

        int updatedAge = field.getInt(person);

        System.out.println("Updated Age: " + updatedAge);
    }
}
