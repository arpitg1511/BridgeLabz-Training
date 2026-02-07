import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGrouping {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Arpit", "A"),
                new Student("Riya", "B"),
                new Student("Rahul", "A"),
                new Student("Neha", "C"),
                new Student("Kunal", "B")
        );

        Map<String, List<String>> studentsByGrade =
                students.stream()
                        .collect(Collectors.groupingBy(
                                s -> s.grade,
                                Collectors.mapping(s -> s.name, Collectors.toList())
                        ));

        studentsByGrade.forEach((grade, names) ->
                System.out.println(grade + " -> " + names)
        );
    }
}
