package oops_practice.scenario_based.student_registration;

import java.util.*;

public class Student extends Person {

    private List<String> courses = new ArrayList<>();
    private Map<String, String> grades = new HashMap<>();
    private static final int MAX_COURSES = 3;

    public Student(int id, String name) {
        super(id, name);
    }

    public void enrollCourse(String course) throws CourseLimitExceededException {
        if (courses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Course limit exceeded");
        }
        courses.add(course);
    }

    public void dropCourse(String course) {
        courses.remove(course);
        grades.remove(course);
    }

    public void addGrade(String course, String grade) {
        if (courses.contains(course)) {
            grades.put(course, grade);
        }
    }

    public void viewCourses() {
        System.out.println("Enrolled Courses: " + courses);
    }

    public void viewGrades() {
        System.out.println("Grades: " + grades);
    }
}
