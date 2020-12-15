package local.algorithm.leetcode.lcof;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/11 15:20
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int value : arr) {
            queue.add(value);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int size = queue.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
