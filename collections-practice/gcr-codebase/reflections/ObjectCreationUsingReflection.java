import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

public class CreateObjectUsingReflection {

    public static void main(String[] args) throws Exception {

        Class<?> cls = Student.class;

        Constructor<?> constructor =
                cls.getDeclaredConstructor(String.class, int.class);

        Object obj = constructor.newInstance("Arpit", 21);

        Student student = (Student) obj;

        student.display();
    }
}
