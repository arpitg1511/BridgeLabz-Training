import java.util.HashMap;
import java.util.Map;

class AnswerSheet {
    private Map<Integer, String> responses = new HashMap<>();

    public void saveAnswer(int questionId, String answer) {
        responses.put(questionId, answer);
        System.out.println("Answer saved for Question " + questionId);
    }

    public Map<Integer, String> getAllResponses() {
        return responses;
    }
}
