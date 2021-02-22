package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {

    TreeMap<Integer, Integer> leaderByTime = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int maxVote = 0, currentLeader = -1;
        Map<Integer, Integer> votes = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
            int vote = votes.getOrDefault(persons[i], 0) + 1;
            if (vote >= maxVote) {
                maxVote = vote;
                currentLeader = persons[i];
            }
            votes.put(persons[i], vote);
            leaderByTime.put(times[i], currentLeader);
        }
    }

    public int q(int t) {
        return leaderByTime.floorEntry(t).getValue();
    }
}
