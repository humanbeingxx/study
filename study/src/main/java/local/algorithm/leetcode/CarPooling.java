package local.algorithm.leetcode;

/**
 * @author cuixiaoshuang
 * @date 2019-12-25
 **/
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] used = new int[1000];
        for (int[] trip : trips) {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];
            for (int i = start; i < end; i++) {
                used[i] += passenger;
            }
        }
        for (int i : used) {
            if (i > capacity) {
                return false;
            }
        }
        return true;
    }
}
