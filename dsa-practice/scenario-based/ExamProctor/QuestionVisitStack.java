import java.util.*;

class QuestionVisitStack {
    private Stack<Integer> visitHistory = new Stack<>();

    public void openQuestion(int questionId) {
        visitHistory.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    public Integer lastVisited() {
        if (visitHistory.isEmpty()) {
            System.out.println("No questions visited yet.");
            return null;
        }
        return visitHistory.peek();
    }
}
