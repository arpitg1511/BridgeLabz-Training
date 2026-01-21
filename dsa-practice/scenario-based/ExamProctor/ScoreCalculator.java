import java.util.Map;

class ScoreCalculator {

    public int computeScore(Map<Integer, String> studentAnswers,
                            Map<Integer, String> correctAnswers) {

        int score = 0;

        for (Integer qId : correctAnswers.keySet()) {
            if (studentAnswers.containsKey(qId) &&
                studentAnswers.get(qId).equals(correctAnswers.get(qId))) {
                score++;
            }
        }
        return score;
    }
}
