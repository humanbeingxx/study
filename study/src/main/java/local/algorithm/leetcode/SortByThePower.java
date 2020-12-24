package local.algorithm.leetcode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByThePower {

    public int getKth(int lo, int hi, int k) {
        if (lo == hi) {
            return lo;
        }
        Map<Integer, Integer> calculated = new HashMap<>();
        calculated.put(1, 0);
        for (int i = lo; i <= hi; i++) {
            calc(i, calculated);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int w1 = o1[1], w2 = o2[1];
            int v1 = o1[0], v2 = o2[0];
            if (w1 != w2) {
                return w2 - w1;
            } else {
                return v2 - v1;
            }
        });
        for (int i = lo; i <= hi; i++) {
            queue.add(new int[]{i, calculated.get(i)});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll()[0];
    }

    private int calc(int i, Map<Integer, Integer> calculated) {
        if (calculated.containsKey(i)) {
            return calculated.get(i);
        }
        if (i % 2 == 0) {
            calculated.put(i, calc(i / 2, calculated) + 1);
        } else {
            calculated.put(i, calc(i * 3 + 1, calculated) + 1);
        }
        return calculated.get(i);
    }
}
