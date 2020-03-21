package local.algorithm.leetcode;

import java.util.*;

public class RankTeams {

    private class TeamRank {
        char team;
        int[] rankCounts = new int[26];

        public TeamRank(char team) {
            this.team = team;
        }
    }

    public String rankTeams(String[] votes) {
        Map<Character, TeamRank> teamRanks = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char team = vote.charAt(i);
                teamRanks.putIfAbsent(team, new TeamRank(team));
                teamRanks.get(team).rankCounts[i]++;
            }
        }

        List<TeamRank> ranks = new ArrayList<>(teamRanks.values());
        ranks.sort((o1, o2) -> {
            int[] rank1 = o1.rankCounts;
            int[] rank2 = o2.rankCounts;
            for (int i = 0; i < rank1.length; i++) {
                if (rank1[i] > rank2[i]) {
                    return -1;
                } else if (rank1[i] < rank2[i]) {
                    return 1;
                }
            }
            return o1.team - o2.team;
        });

        StringBuilder sb = new StringBuilder();
        for (TeamRank teamRank : ranks) {
            sb.append(teamRank.team);
        }

        return sb.toString();
    }
}
