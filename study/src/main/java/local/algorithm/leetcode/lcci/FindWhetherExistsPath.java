package local.algorithm.leetcode.lcci;

import java.util.*;

public class FindWhetherExistsPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        for (int[] edge : graph) {
            if (edge[0] == edge[1]) {
                continue;
            }
            graphMap.putIfAbsent(edge[0], new HashSet<>());
            graphMap.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> checked = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) {
                    return true;
                }
                if (checked.contains(poll)) {
                    continue;
                }
                checked.add(poll);
                if (graphMap.containsKey(poll)) {
                    queue.addAll(graphMap.get(poll));
                }
            }
        }
        return false;
    }
}
