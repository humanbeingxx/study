package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> existSubSequences = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> exists = existSubSequences.get(num - 1);
            int grownLength = 0;
            if (exists == null || exists.isEmpty()) {
                grownLength = 1;
            } else {
                grownLength = exists.poll() + 1;
            }
            PriorityQueue<Integer> queue = existSubSequences.getOrDefault(num, new PriorityQueue<>());
            queue.add(grownLength);
            existSubSequences.put(num, queue);
        }
        for (PriorityQueue<Integer> queue : existSubSequences.values()) {
            if (!queue.isEmpty() && queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
