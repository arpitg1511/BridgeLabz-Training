package oops_practice.scenario_based.student_registration;

public class CourseLimitExceededException extends Exception {

    public CourseLimitExceededException(String message) {
        super(message);
    }
}
