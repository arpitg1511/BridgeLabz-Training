package oops_practice.scenario_based.student_registration;

public interface RegistrationService {

    void registerStudent(Student student);
    void enroll(Student student, String course) throws CourseLimitExceededException;
    void drop(Student student, String course);
}
