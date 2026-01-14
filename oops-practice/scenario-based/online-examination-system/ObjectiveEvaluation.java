package online_examination_system;

import java.util.*;

public class ObjectiveEvaluation implements EvaluationStrategy {

    public int evaluate(List<Question> questions, List<String> answers) {
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getCorrectAnswer()
                    .equalsIgnoreCase(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}

