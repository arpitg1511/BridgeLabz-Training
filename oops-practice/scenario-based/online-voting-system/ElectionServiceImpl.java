package online_voting_system;

import java.util.*;

public class ElectionServiceImpl implements ElectionService {

    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    public void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException {

        if (voter.hasVoted()) {
            throw new DuplicateVoteException(
                "Voter has already voted"
            );
        }

        voter.markVoted();
        candidate.addVote();
        votes.add(new Vote(voter, candidate));

        System.out.println("Vote cast successfully");
    }

    public void declareResult() {
        System.out.println("\nElection Results:");
        for (Candidate c : candidates) {
            System.out.println(
                c.getName() + " : " + c.getVotes() + " votes"
            );
        }
    }
}

