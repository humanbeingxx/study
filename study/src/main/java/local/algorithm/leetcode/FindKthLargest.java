package local.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cuixiaoshuang
 * @date 2020-02-07
 **/
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
