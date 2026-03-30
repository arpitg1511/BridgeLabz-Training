package online_examination_system;

import java.util.*;

public class Exam {

    private final int examId;
    private String subject;
    private List<Question> questions = new ArrayList<>();

    Exam(int id, String subject) {
        this.examId = id;
        this.subject = subject;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }

    List<Question> getQuestions() {
        return questions;
    }

    String getSubject() {
        return subject;
    }
}

