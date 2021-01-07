package local.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, provinceCount = 0;
        boolean[] checked = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        while (true) {
            int startCity = next(checked);
            if (startCity == -1) {
                break;
            }
            queue.add(startCity);
            provinceCount++;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    checked[poll]= true;
                    for (int next = 0; next < n; next++) {
                        if (isConnected[poll][next] == 1 && !checked[next]) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return provinceCount;
    }

    private int next(boolean[] checked) {
        for (int i = 0; i < checked.length; i++) {
            if (!checked[i]) {
                return i;
            }
        }
        return -1;
    }
}
