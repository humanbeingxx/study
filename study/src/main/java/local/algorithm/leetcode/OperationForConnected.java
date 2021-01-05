package local.algorithm.leetcode;

import java.util.*;

public class OperationForConnected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int groupCount = 0;
        Set<Integer> remainNodes = initAllNodes(n);
        Map<Integer, List<Integer>> connectionMap = initMap(connections);
        Queue<Integer> queue = new LinkedList<>();
        while (!remainNodes.isEmpty()) {
            groupCount++;
            Integer pickOne = remainNodes.iterator().next();
            queue.add(pickOne);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    if (connectionMap.containsKey(poll) && remainNodes.contains(poll)) {
                        queue.addAll(connectionMap.get(poll));
                    }
                    remainNodes.remove(poll);
                }
            }
        }
        return groupCount - 1;
    }

    private Map<Integer, List<Integer>> initMap(int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] connection : connections) {
            map.putIfAbsent(connection[0], new ArrayList<>());
            map.putIfAbsent(connection[1], new ArrayList<>());
            map.get(connection[0]).add(connection[1]);
            map.get(connection[1]).add(connection[0]);
        }
        return map;
    }

    private Set<Integer> initAllNodes(int n) {
        Set<Integer> allNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            allNodes.add(i);
        }
        return allNodes;
    }

    public int makeConnected2(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }
        for (int[] connection : connections) {
            int root0 = findRoot(connection[0], union);
            int root1 = findRoot(connection[1], union);
            if (root0 <= root1) {
                union[root1] = root0;
            } else {
                union[root0] = root1;
            }
        }
        Set<Integer> split = new HashSet<>();
        for (int i = 0; i < n; i++) {
            split.add(findRoot(i, union));
        }
        return split.size() - 1;
    }

    private int findRoot(int target, int[] union) {
        if (union[target] == target) {
            return target;
        }
        union[target] = findRoot(union[target], union);
        return union[target];
    }
}
