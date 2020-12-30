package local.algorithm.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeight2 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.poll();
            }
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (x > y) {
                queue.add(x - y);
            }
        }
        return 0;
    }
}
