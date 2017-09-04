package no.hvl.dat104;

import java.util.HashMap;
import java.util.Map;

public class Votes {

    private Map<Integer, Integer> votes;

    Votes() {
        this.votes = new HashMap<>();
    }

    void addVote(int valg) {
        votes.put(valg, votes.get(valg) + 1);
        System.out.println(votes.get(valg));
    }

    public Map<Integer, Integer> getVotes() {
        return votes;
    }

    public void setVotes(Map<Integer, Integer> votes) {
        this.votes = votes;
    }
}
