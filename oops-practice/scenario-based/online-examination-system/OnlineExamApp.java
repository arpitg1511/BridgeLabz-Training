package online_examination_system;


import java.util.*;

public class OnlineExamApp {

    public static void main(String[] args) {

        Exam exam = new Exam(1, "Java");

        exam.addQuestion(new Question(1, "What is JVM?", "Virtual Machine"));
        exam.addQuestion(new Question(2, "What is OOP?", "Programming"));

        Student s1 = new Student(101, "Arpit");

        ExamService service = new ExamService();
        service.enrollStudent(s1);

        List<String> answers = new ArrayList<>();
        answers.add("Virtual Machine");
        answers.add("Programming");

        EvaluationStrategy evaluator = new ObjectiveEvaluation();

        try {
            int result = service.submitAnswers(
                    exam,
                    answers,
                    evaluator,
                    false
            );
            System.out.println("Score: " + result);
        }
        catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}

