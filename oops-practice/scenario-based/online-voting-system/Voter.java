package online_voting_system;

public class Voter {

    private final int voterId;
    private String name;
    private boolean hasVoted = false;

    Voter(int id, String name) {
        this.voterId = id;
        this.name = name;
    }

    int getId() {
        return voterId;
    }

    String getName() {
        return name;
    }

    boolean hasVoted() {
        return hasVoted;
    }

    void markVoted() {
        hasVoted = true;
    }
}
