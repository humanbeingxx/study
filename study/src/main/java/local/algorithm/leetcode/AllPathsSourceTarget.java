package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> onePath = new ArrayList<>();
        onePath.add(0);
        findRec(graph, 0, onePath, result);
        return result;
    }

    private void findRec(int[][] graph, int currIndex, List<Integer> onePath, List<List<Integer>> result) {
        if (currIndex == graph.length - 1) {
            result.add(new ArrayList<>(onePath));
            return;
        }
        int[] nexts = graph[currIndex];
        for (int next : nexts) {
            onePath.add(next);
            findRec(graph, next, onePath, result);
            onePath.remove(onePath.size() - 1);
        }
    }
}
