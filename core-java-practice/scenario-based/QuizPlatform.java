import java.util.*;

// custom exception for invalid quiz submission
class InvalidQuizSubmissionException extends Exception {

    InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

// quiz result processor
class QuizProcessor {

    // compare answers and calculate score
    static int calculateScore(String[] correctAnswers, String[] userAnswers)
            throws InvalidQuizSubmissionException {

        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException(
                    "Number of answers does not match the quiz questions");
        }

        int score = 0;

        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }

        return score;
    }

    // return grade based on score
    static String getGrade(int score, int totalQuestions) {

        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 80) return "A";
        if (percentage >= 60) return "B";
        if (percentage >= 40) return "C";
        return "F";
    }
}

// main class
public class QuizPlatform {

    public static void main(String[] args) {

        String[] correctAnswers = {"A", "B", "C", "D", "A"};

        // scores of multiple users
        List<Integer> scores = new ArrayList<>();

        try {
            String[] user1 = {"A", "B", "C", "D", "A"};
            int score1 = QuizProcessor.calculateScore(correctAnswers, user1);
            scores.add(score1);
            System.out.println("User 1 Score: " + score1);
            System.out.println("User 1 Grade: " +
                    QuizProcessor.getGrade(score1, correctAnswers.length));

            String[] user2 = {"A", "C", "C", "D", "B"};
            int score2 = QuizProcessor.calculateScore(correctAnswers, user2);
            scores.add(score2);
            System.out.println("User 2 Score: " + score2);
            System.out.println("User 2 Grade: " + QuizProcessor.getGrade(score2, correctAnswers.length));

            // invalid submission (length mismatch)
            String[] user3 = {"A", "B"};
            QuizProcessor.calculateScore(correctAnswers, user3);

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All User Scores: " + scores);
    }
}
