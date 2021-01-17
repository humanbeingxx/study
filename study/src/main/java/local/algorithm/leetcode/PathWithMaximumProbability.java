package local.algorithm.leetcode;

import java.util.*;

public class PathWithMaximumProbability {

    static class Edge {
        int end;
        double p;

        public Edge(int end, double p) {
            this.end = end;
            this.p = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probabilities = new double[n];
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new Edge(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Edge(edge[0], succProb[i]));
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2.p, o1.p));
        queue.add(new Edge(start , 1));
        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (probabilities[poll.end] > 0) {
                continue;
            }
            probabilities[poll.end] = poll.p;
            if (poll.end == end) {
                return poll.p;
            }
            if (graph.containsKey(poll.end)) {
                for (Edge edge : graph.get(poll.end)) {
                    queue.add(new Edge(edge.end, edge.p * poll.p));
                }
            }
        }
        return probabilities[end];
    }

}
