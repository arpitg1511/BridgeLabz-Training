package online_examination_system;

import java.util.*;

public class ExamService {

    private List<Student> students = new ArrayList<>();

    void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student enrolled: " + student.getName());
    }

    int submitAnswers(
            Exam exam,
            List<String> answers,
            EvaluationStrategy strategy,
            boolean timeExpired
    ) throws ExamTimeExpiredException {

        if (timeExpired) {
            throw new ExamTimeExpiredException("Exam time expired");
        }

        return strategy.evaluate(exam.getQuestions(), answers);
    }
}

