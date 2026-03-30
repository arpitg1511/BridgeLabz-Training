package online_examination_system;

import java.util.*;

public class DescriptiveEvaluation implements EvaluationStrategy {

    public int evaluate(List<Question> questions, List<String> answers) {
        // simplified evaluation
        return questions.size(); // assume full marks
    }
}

