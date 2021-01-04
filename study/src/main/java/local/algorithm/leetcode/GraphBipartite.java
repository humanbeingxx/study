package local.algorithm.leetcode;

import java.util.*;

public class GraphBipartite {

    public boolean isBipartite(int[][] graph) {
        Set<Integer> allNodes = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            allNodes.add(i);
        }
        int[] colors = new int[graph.length];
        Queue<Integer> nexts = new LinkedList<>();
        while (!allNodes.isEmpty()) {
            int firstInTurn = allNodes.iterator().next();
            nexts.add(firstInTurn);
            colors[firstInTurn] = 1;
            while (!nexts.isEmpty()) {
                for (int i = 0; i < nexts.size(); i++) {
                    Integer node = nexts.poll();
                    allNodes.remove(firstInTurn);
                    for (int next : graph[node]) {
                        if (colors[next] == colors[node]) {
                            return false;
                        } else if (colors[next] == 0) {
                            colors[next] = -colors[node];
                            allNodes.remove(next);
                            nexts.add(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}
