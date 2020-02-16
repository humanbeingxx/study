package local.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-16
 **/
public class KClosest {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dis1 = o1[1] * o1[1] + o1[2] * o1[2];
                int dis2 = o2[1] * o2[1] + o2[2] * o2[2];
                return dis2 - dis1;
            }
        });
        for (int i = 0; i < points.length; i++) {
            int[] entry = new int[3];
            entry[0] = i;
            entry[1] = points[i][0];
            entry[2] = points[i][1];

            queue.add(entry);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] result = new int[K][2];
        int index = 0;
        for (int[] ints : queue) {
            result[index++] = points[ints[0]];
        }
        return result;
    }
}
