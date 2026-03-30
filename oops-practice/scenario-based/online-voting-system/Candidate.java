package online_voting_system;

public class Candidate {

    private final int candidateId;
    private String name;
    private int votes = 0;

    Candidate(int id, String name) {
        this.candidateId = id;
        this.name = name;
    }

    int getId() {
        return candidateId;
    }

    String getName() {
        return name;
    }

    int getVotes() {
        return votes;
    }

    void addVote() {
        votes++;
    }
}
