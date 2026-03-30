package online_voting_system;

public interface ElectionService {

    void registerVoter(Voter voter);

    void addCandidate(Candidate candidate);

    void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException;

    void declareResult();
}

