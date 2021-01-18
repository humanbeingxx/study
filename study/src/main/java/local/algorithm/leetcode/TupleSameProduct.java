package local.algorithm.leetcode;

import java.util.Arrays;

public class TupleSameProduct {

    public int tupleSameProduct(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length - 1; j >= 3; j--) {
                int product = nums[i] * nums[j];
                for (int k = i + 1; k < j; k++) {
                    if (product % nums[k] == 0 &&
                            Arrays.binarySearch(nums, k + 1, j - 1, product / nums[k]) > 0) {
                        count++;
                    }
                }
            }
        }
        return count * 8;
    }
}
