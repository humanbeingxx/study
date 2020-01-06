package local.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stone : stones) {
            queue.add(-stone);
        }
        while (!queue.isEmpty()) {
            int first = queue.poll();
            Integer second = queue.poll();
            if (second == null) {
                return -first;
            }
            int sub = first - second;
            if (sub != 0) {
                queue.add(sub);
            }
        }
        return 0;
    }
}
