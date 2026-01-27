import java.util.*;

class VotingSystem {
    Map<String, Integer> votes = new HashMap<>();
    Map<String, Integer> order = new LinkedHashMap<>();

    void vote(String candidate) {
        // Manual increment without getOrDefault
        if (votes.containsKey(candidate)) {
            votes.put(candidate, votes.get(candidate) + 1);
        } else {
            votes.put(candidate, 1);
        }

        if (order.containsKey(candidate)) {
            order.put(candidate, order.get(candidate) + 1);
        } else {
            order.put(candidate, 1);
        }
    }

    void showOrder() {
        System.out.println("Votes in order of voting: " + order);
    }

    void showSorted() {
        // TreeMap to sort candidates alphabetically
        TreeMap<String, Integer> sorted = new TreeMap<>();
        for (String c : votes.keySet()) {
            sorted.put(c, votes.get(c));
        }
        System.out.println("Votes sorted by candidate name: " + sorted);
    }
}

public class VotingSystemManagement {
    public static void main(String[] args) {

        VotingSystem v = new VotingSystem();

        // ======= Input from code =======
        String[] votesInput = {"Alice", "Bob", "Alice", "Carol", "Bob", "Alice"};

        for (String candidate : votesInput) {
            v.vote(candidate);
        }

        // ======= Show outputs =======
        v.showOrder();
        v.showSorted();
    }
}
