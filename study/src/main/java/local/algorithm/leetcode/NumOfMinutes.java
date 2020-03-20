package local.algorithm.leetcode;

import java.util.*;

public class NumOfMinutes {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> relations = createRelations(manager);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, informTime[headID]});
        int maxMinutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                List<Integer> nexts = relations.get(poll[0]);
                if (nexts != null) {
                    int currentMinutes = poll[1];
                    for (Integer next : nexts) {
                        int nextTime = informTime[next] + currentMinutes;
                        maxMinutes = Math.max(maxMinutes, nextTime);
                        queue.add(new int[]{next, nextTime});
                    }
                }
            }
        }
        return maxMinutes;
    }

    private Map<Integer, List<Integer>> createRelations(int[] manager) {
        Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            if (m == -1) {
                continue;
            }
            relations.putIfAbsent(m, new ArrayList<>());
            relations.get(m).add(i);
        }
        return relations;
    }
}
