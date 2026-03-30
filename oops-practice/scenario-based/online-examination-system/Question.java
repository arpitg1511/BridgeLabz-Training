package online_examination_system;

public class Question {

    private final int questionId;
    private String questionText;
    private String correctAnswer;

    Question(int id, String text, String answer) {
        this.questionId = id;
        this.questionText = text;
        this.correctAnswer = answer;
    }

    String getCorrectAnswer() {
        return correctAnswer;
    }

    String getQuestionText() {
        return questionText;
    }
}

