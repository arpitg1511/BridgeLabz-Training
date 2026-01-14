package oops_practice.scenario_based.student_registration;

public class StudentCourseApp {

    public static void main(String[] args) {

        Student student = new Student(1, "Arpit");

        RegistrationService service = new RegistrationServiceImpl();
        service.registerStudent(student);

        try {
            service.enroll(student, "Java");
            service.enroll(student, "DBMS");
            service.enroll(student, "OS");
            service.enroll(student, "CN"); // exception
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        student.viewCourses();

        student.addGrade("Java", "A");
        student.addGrade("DBMS", "B");

        student.viewGrades();

        service.drop(student, "OS");
        student.viewCourses();
    }
}
