package local.algorithm;

import java.util.*;

public class DijkstraPath {

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public List<Edge> bestPath(int[][] edges) {
        List<Edge> result = new ArrayList<>();
        Map<Integer, List<Edge>> graph = buildGraph(edges);
        Set<Integer> used = new HashSet<>();
        PriorityQueue<Edge> candidateEdges = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        used.add(0);
        if (!graph.containsKey(0)) {
            return result;
        }
        candidateEdges.addAll(graph.get(0));
        while (!candidateEdges.isEmpty()) {
            Edge min = candidateEdges.poll();
            if (used.contains(min.end)) {
                continue;
            }
            result.add(min);
            if (graph.containsKey(min.end)) {
                candidateEdges.addAll(graph.get(min.end));
            }
        }
        return result;
    }

    private Map<Integer, List<Edge>> buildGraph(int[][] edges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[1], edge[0], edge[2]));
        }
        return graph;
    }
}
