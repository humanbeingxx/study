package local.algorithm.leetcode;

import java.util.*;

/**
 * @author cuixiaoshuang
 * @date 2020-02-08
 **/
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[1]]++;
        }
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            preMap.putIfAbsent(prerequisite[0], new ArrayList<>());
            preMap.get(prerequisite[0]).add(prerequisite[1]);
        }

        List<Integer> sortedByDegree = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            sortedByDegree.add(node);
            List<Integer> nextNodes = preMap.get(node);
            if (nextNodes == null) {
                continue;
            }
            for (Integer nextNode : nextNodes) {
                degrees[nextNode]--;
                if (degrees[nextNode] == 0) {
                    queue.add(nextNode);
                }
            }
        }

        return sortedByDegree.size() == numCourses;
    }
}
