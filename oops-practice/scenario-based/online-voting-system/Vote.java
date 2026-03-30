package online_voting_system;

public class Vote {

    private Voter voter;
    private Candidate candidate;

    Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    void display() {
        System.out.println(
            voter.getName() + " voted for " + candidate.getName()
        );
    }
}
