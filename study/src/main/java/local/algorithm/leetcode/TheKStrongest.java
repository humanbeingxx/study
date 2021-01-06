package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKStrongest {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1 - m);
            int abs2 = Math.abs(o2 - m);
            if (abs1 != abs2) {
                return abs1 - abs2;
            } else {
                return o1 - o2;
            }
        });
        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        return result;
    }
}
