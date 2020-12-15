package local.algorithm.leetcode;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> depMap = new HashMap<>();
        Map<Integer, Set<Integer>> depedMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            depMap.putIfAbsent(prerequisite[0], new HashSet<>());
            depMap.get(prerequisite[0]).add(prerequisite[1]);
            depedMap.putIfAbsent(prerequisite[1], new HashSet<>());
            depedMap.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> available = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!depMap.containsKey(i)) {
                available.add(i);
            }
        }
        int[] result = new int[numCourses];
        int resultIndex = 0;
        while (!available.isEmpty()) {
            int size = available.size();
            for (int i = 0; i < size; i++) {
                Integer poll = available.poll();
                result[resultIndex++] = poll;
                Set<Integer> deps = depedMap.get(poll);
                if (deps == null) {
                    continue;
                }
                for (Integer dep : deps) {
                    depMap.get(dep).remove(poll);
                    if (depMap.get(dep).isEmpty()) {
                        depMap.remove(dep);
                        available.add(dep);
                    }
                }
            }
        }
        if (!depMap.isEmpty()) {
            return new int[0];
        } else {
            return result;
        }
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.putIfAbsent(prerequisite[1], new ArrayList<>());
            edges.get(prerequisite[1]).add(prerequisite[0]);
            degrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int in = queue.poll();
                result[resultIndex++] = in;
                List<Integer> outs = edges.get(in);
                if (outs != null) {
                    for (Integer out : outs) {
                        degrees[out]--;
                        if (degrees[out] == 0) {
                            queue.add(out);
                        }
                    }
                }
            }
        }
        if (resultIndex != numCourses) {
            return new int[0];
        } else {
            return result;
        }
    }
}
