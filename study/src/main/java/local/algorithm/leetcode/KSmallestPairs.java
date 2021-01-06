package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1));
        for (int val1 : nums1) {
            for (int val2 : nums2) {
                priorityQueue.add(pair(val1, val2));
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(priorityQueue);
        result.sort((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        return result;
    }

    public List<List<Integer>> kSmallestPairsBetter1(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>(k);
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        for (int i = 0; i < nums1.length; i++) {
            priorityQueue.add(pair(nums1[i], nums2[0], i, 0));
        }
        while (result.size() < k && !priorityQueue.isEmpty()) {
            List<Integer> poll = priorityQueue.poll();
            result.add(pair(poll.get(0), poll.get(1)));
            if (poll.get(3) < nums2.length - 1) {
                priorityQueue.add(pair(nums1[poll.get(2)], nums2[poll.get(3) + 1], poll.get(2), poll.get(3) + 1));
            }
        }
        return result;
    }

    private List<Integer> pair(int... nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }
}
