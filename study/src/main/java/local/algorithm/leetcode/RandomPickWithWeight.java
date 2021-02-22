package local.algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    private int[] sum;
    private Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = w[i] + sum[i - 1];
        }
    }

    public int pickIndex() {
        int nextInt = random.nextInt(sum[sum.length - 1]);
        if (nextInt == 0) {
            return 0;
        }
        int pos = Arrays.binarySearch(sum, nextInt);
        if (pos >= 0) {
            return pos + 1;
        } else {
            return -pos - 1;
        }
    }
}
