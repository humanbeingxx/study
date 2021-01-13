package local.algorithm.leetcode;

import java.util.*;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] connectionCount = new int[n];
        for (int[] road : roads) {
            connectionCount[road[0]]++;
            connectionCount[road[1]]++;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.putIfAbsent(road[0], new HashSet<>());
            graph.putIfAbsent(road[1], new HashSet<>());
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int max = 0, secondMax = 0;
        for (int count : connectionCount) {
            if (count > max) {
                secondMax = max;
                max = count;
            } else if (count < max && count > secondMax) {
                secondMax = count;
            }
        }
        List<Integer> maxNodes = new ArrayList<>();
        List<Integer> secondNodes = new ArrayList<>();
        for (int i = 0; i < connectionCount.length; i++) {
            int count = connectionCount[i];
            if (count == max) {
                maxNodes.add(i);
            } else if (count == secondMax) {
                secondNodes.add(i);
            }
        }
        if (maxNodes.size() > 1) {
            for (Integer node1 : maxNodes) {
                for (Integer node2 : maxNodes) {
                    if (!node1.equals(node2)) {
                        if (!graph.containsKey(node1) ||  !graph.get(node1).contains(node2)) {
                            return 2 * max;
                        }
                    }
                }
            }
            return 2 * max - 1;
        } else {
            for (Integer node1 : maxNodes) {
                for (Integer node2 : secondNodes) {
                    if (!graph.containsKey(node1) || !graph.get(node1).contains(node2)) {
                        return max + secondMax;
                    }
                }
            }
            return max + secondMax - 1;

        }
    }
}
