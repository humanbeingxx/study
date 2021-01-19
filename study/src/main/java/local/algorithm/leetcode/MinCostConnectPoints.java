package local.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }
        PriorityQueue<int[]> edges = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        int[] unionSet = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                edges.add(new int[]{i, j, Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1])});
            }
            unionSet[i] = i;
        }

        int cost = 0, containEdge = 0;
        while (containEdge != points.length - 1) {
            int[] minEdge = edges.poll();
            int root1 = findRoot(unionSet, minEdge[0]);
            int root2 = findRoot(unionSet, minEdge[1]);
            if (root1 != root2) {
                unionSet[root1] = root2;
                cost += minEdge[2];
                containEdge++;
            }
        }
        return cost;
    }

    private int findRoot(int[] unionSet, int node) {
        int find = node;
        while (unionSet[find] != find) {
            find = unionSet[find];
        }
        unionSet[node] = find;
        return find;
    }

}
