import java.util.ArrayList;
import java.util.List;

/* ---------- Course Type Hierarchy ---------- */

abstract class CourseType {
    public abstract String getEvaluationMethod();
}

class ExamCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

/* ---------- Generic Course Class ---------- */

class Course<T extends CourseType> {

    private final String courseCode;
    private final String courseName;
    private final T courseType;

    public Course(String courseCode, String courseName, T courseType) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourse() {
        System.out.println(
                courseCode + " - " + courseName +
                " | " + courseType.getEvaluationMethod()
        );
    }
}

/* ---------- Course Utility Using Wildcards ---------- */

class CourseViewer {

    public static void showAllCourses(List<? extends CourseType> courseTypes) {
        System.out.println("\nEvaluation Methods Available:");
        for (CourseType type : courseTypes) {
            System.out.println("- " + type.getEvaluationMethod());
        }
    }
}

/* ---------- Driver Class ---------- */

public class UniversityCourseApp {

    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("MTH101", "Calculus", new ExamCourse());

        Course<AssignmentCourse> cs =
                new Course<>("CSE201", "Data Structures", new AssignmentCourse());

        Course<ResearchCourse> phd =
                new Course<>("RES501", "AI Research", new ResearchCourse());

        math.displayCourse();
        cs.displayCourse();
        phd.displayCourse();

        List<CourseType> evaluationList = new ArrayList<>();
        evaluationList.add(new ExamCourse());
        evaluationList.add(new AssignmentCourse());
        evaluationList.add(new ResearchCourse());

        CourseViewer.showAllCourses(evaluationList);
    }
}
