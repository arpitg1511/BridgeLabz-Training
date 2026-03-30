package online_examination_system;
import java.util.*;

public interface EvaluationStrategy {
    int evaluate(List<Question> questions, List<String> answers);
}

