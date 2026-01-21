import java.util.HashMap;
import java.util.Map;

public class ExamProctorApp {
    public static void main(String[] args) {

        QuestionVisitStack tracker = new QuestionVisitStack();
        AnswerSheet sheet = new AnswerSheet();
        ScoreCalculator evaluator = new ScoreCalculator();

        // Simulating navigation
        tracker.openQuestion(1);
        tracker.openQuestion(2);
        tracker.openQuestion(3);

        // Saving answers
        sheet.saveAnswer(1, "A");
        sheet.saveAnswer(2, "B");
        sheet.saveAnswer(3, "C");

        // Correct answer key
        Map<Integer, String> answerKey = new HashMap<>();
        answerKey.put(1, "A");
        answerKey.put(2, "C");
        answerKey.put(3, "C");

        int finalScore = evaluator.computeScore(
                sheet.getAllResponses(), answerKey);

        System.out.println("Final Score: " + finalScore);
        System.out.println("Last Question Visited: " + tracker.lastVisited());
    }
}
