package oops_practice.scenario_based.student_registration;

public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void registerStudent(Student student) {
        System.out.println("Student registered: " + student.name);
    }

    @Override
    public void enroll(Student student, String course) throws CourseLimitExceededException {
        student.enrollCourse(course);
        System.out.println("Enrolled in course: " + course);
    }

    @Override
    public void drop(Student student, String course) {
        student.dropCourse(course);
        System.out.println("Dropped course: " + course);
    }
}
