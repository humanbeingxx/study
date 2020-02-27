package local.algorithm.leetcode;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int cost = time[2];
            map.putIfAbsent(from, new HashMap<>());
            map.get(from).put(to, cost);
        }

        int[] costs = new int[N];
        Arrays.fill(costs, -1);
        costs[K - 1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);
        while (!queue.isEmpty()) {
            boolean changed = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                Map<Integer, Integer> nexts = map.get(poll);
                if (nexts != null) {
                    for (Map.Entry<Integer, Integer> entry : nexts.entrySet()) {
                        int cost = costs[poll - 1] + entry.getValue();
                        if (costs[entry.getKey() - 1] == -1 || cost < costs[entry.getKey() - 1]) {
                            costs[entry.getKey() - 1] = cost;
                            changed = true;
                            queue.add(entry.getKey());
                        }
                    }
                }
            }
            if (!changed) {
                break;
            }
        }

        int max = -1;
        for (int cost : costs) {
            if (cost == -1) {
                return -1;
            }
            max = Math.max(cost, max);
        }
        return max;
    }
}
